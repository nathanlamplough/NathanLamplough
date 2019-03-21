#include "cuda_runtime.h"
#include "device_launch_parameters.h"
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <random>
#include <string>
#include <unordered_map>
#include <algorithm>
#include <vector>
#include "windows.h"
#include "psapi.h"
#include <math.h> 

#define OTL_ODBC 
#define OTL_ODBC_SELECT_STM_EXECUTE_BEFORE_DESCRIBE
#include <otlv4.h>

using namespace std;


int IDs[1470908];
otl_connect db;
mt19937 random_generator;
const int vector_size = 9777;
const int n_vectors = 100;

int single_vector[vector_size];
float * vectors = new float[vector_size * n_vectors];

//class to help store cluster and distance data for vectors
class c_data
{
public:

	int cluster;
	float distance;
};

//dictionary to store the vector and its cluster and distance from centroid 
unordered_map<int, c_data> cluster_data;

void print_memory_usage() {
	PROCESS_MEMORY_COUNTERS pmc;
	GetProcessMemoryInfo(GetCurrentProcess(), &pmc, sizeof(pmc));
	SIZE_T virtualMemUsedByMe = pmc.WorkingSetSize;
	cout << "************ Current Memory Usage: " << virtualMemUsedByMe / 1048576 << " Megabytes ************" << endl;
}

void print_cluster_data() {
	ofstream myfile;
	myfile.open("C:/Users/natha/source/repos/Kmeans_cuda2/Kmeans_cuda2/data/cluster_data.txt");
	for (int i = 0; i < 1470908; i++) {
		int id = IDs[i];
		myfile << id << " " << cluster_data[id].cluster << " " << cluster_data[id].distance << endl;
	}
}

//computes the distance by column from centroid to vector and squares to avoid negative numbers
__global__ void dist(float * dist_out, float * d_vect, float * d_cent) {
	int row = threadIdx.x;
	int column = blockIdx.x;
	float distance = d_cent[column] - d_vect[row * vector_size + column];
	float sq_distance = distance * distance;
	dist_out[row * vector_size + column] = sq_distance;
}

//sums the column distances to give a scalar distance
__global__ void sumDist(float * d_dist_out, float * d_dist_in) {
	float sum = 0;
	int row = threadIdx.x;
	for (int i = 0; i < vector_size; i++) {
		sum = sum + d_dist_in[vector_size * row + i];
	}
	d_dist_out[row] = sum;
}
//computes the mean of each column over all vectors assigned to each cluster, the mean is the columns is then the new centroid column value
__global__ void mean(float * d_cent_out, int * d_vect_in, int * d_ends, int * d_cent_in) {
	float mean = 0;
	float sum = 0;
	int cluster = threadIdx.x;
	int column = blockIdx.x;

	for (int i = 0; i < d_ends[cluster]; i++) {
		sum = sum + d_vect_in[d_cent_in[cluster * n_vectors + i] * vector_size + column];
	}
	mean = sum / d_ends[cluster];
	d_cent_out[column] = mean;
}


//functions to connect to SQL database and retrieve word vectors for clustering into RAM
class database_functions {

public:

	void select_vectors() {
		try {

			db.rlogon("natha/@Vectors");

			int c = 0;
			for (int j = 0; j < n_vectors; j++) {
				otl_long_string Vector(40000);
				db.set_max_long_size(40000);
				otl_connect::otl_initialize();

				otl_stream i(50,
					"SELECT * FROM WordVectors "
					"where ID=:ID<int>",

					db
				);


				int ID;
				int id = IDs[j];
				i << id;


				while (!i.eof()) {
					i >> ID;
					i >> Vector;
					string current_value = "";

					for (int j = 0; Vector[j] != 0; ++j) {
						int converted_char = Vector[j];
						if (converted_char == 32) {
							int int_value = stoi(current_value);
							vectors[c] = int_value;
							current_value = "";
							c++;
						}
						else {
							int real_value = converted_char - 48;
							string string_value = to_string(real_value);
							current_value += string_value;
						}
					}
					int int_value = stoi(current_value);
					vectors[c] = int_value;
					c++;

				}

			}
		}
		catch (otl_exception& p) {
			cerr << p.msg << endl;
			cerr << p.stm_text << endl;
			cerr << p.var_info << endl;
		}

		db.logoff();
	}

	void select_one_vector(int id) {
		otl_connect::otl_initialize();

		try {

			db.rlogon("natha/@Vectors");

			otl_long_string Vector(40000);
			db.set_max_long_size(40000);

			otl_stream i(50,
				"SELECT * FROM WordVectors "
				"where ID=:ID<int>",

				db
			);


			int ID;
			i << IDs[id];

			while (!i.eof()) {
				i >> ID;
				i >> Vector;
				string current_value = "";
				int c = 0;
				for (int j = 0; Vector[j] != 0; ++j) {
					int converted_char = Vector[j];
					if (converted_char == 32) {
						int int_value = stoi(current_value);
						single_vector[c] = int_value;
						current_value = "";
						c++;
					}
					else {
						int real_value = converted_char - 48;
						string string_value = to_string(real_value);
						current_value += string_value;
					}
				}
				int int_value = stoi(current_value);
				single_vector[c] = int_value;

			}
		}

		catch (otl_exception& p) {
			cerr << p.msg << endl;
			cerr << p.stm_text << endl;
			cerr << p.var_info << endl;
		}

		db.logoff();
	}


	void select_ids() {
		otl_stream i(50, // buffer size
			"SELECT ID FROM WordVectors",
			db
		);

		int ID;

		int count = 0;
		while (!i.eof()) {
			i >> ID;
			IDs[count] = ID;
			count++;

		}
	}
	void intialise_database() {

		otl_connect::otl_initialize();
		try {

			db.rlogon("natha/@Vectors");
			print_memory_usage();
			select_ids();


		}
		catch (otl_exception& p) {
			cerr << p.msg << endl;
			cerr << p.stm_text << endl;
			cerr << p.var_info << endl;
		}

		db.logoff();


	}
};




cudaError_t kmeans(database_functions dbc)
{
	cudaError_t cudaStatus;
	cudaStatus = cudaSetDevice(0);


	const int clusters = 20;
	const int iterations = 10;
	//int vectors[1000 * 100];
	int centroidsIndex[clusters];
	float * centroids = new float[clusters * vector_size];

	//random_generator.seed(5);
	//uniform_int<int> rand25(1, 25);
	uniform_int<int> rand1000(0, 1470908);
	////randomly create vectors for testing purposes
	//for (int i = 0; i < 1000 * 100; i++) {
	//	vectors[i] = rand25(random_generator);
	//}
	//randomly assign centroids
	for (int c = 0; c < clusters; c++) {
		centroidsIndex[c] = rand1000(random_generator);
	}

	//create copies of centroids 
	int row = 0;
	for (const auto& index : centroidsIndex) {
		dbc.select_one_vector(index);
		for (int c = 0; c < vector_size; c++) {
			centroids[row * vector_size + c] = single_vector[c];
		}
		row++;
	}

	bool first = true;

	//get the sizes the variables for memcpy
	const int ARRAY_BYTES_VECTORS = sizeof(float) * n_vectors * vector_size;
	const int ARRAY_BYTES_CENTROIDS = sizeof(float) * clusters * vector_size;
	const int ARRAY_BYTES_DISTANCES = sizeof(float) * n_vectors * vector_size;

	//run kmeans for specified iterations
	for (int iter = 0; iter < iterations; iter++) {
		//loop and find distances to vectors for each centroid
		for (int vc = 0; vc < 150; vc++) {
			dbc.select_vectors();

			cout << "------------ Beginning round " << vc + 1 << " of " << n_vectors << " vectors" << " ------------" << endl;
			print_memory_usage();
			if (iter < 1) {
				first = true;
			}
			else {
				first = false;
			}
			for (int fv = 0; fv < n_vectors; fv++) {
				c_data c;
				cluster_data.insert({ IDs[n_vectors * vc + fv], c });
			}

			for (int cent = 0; cent < clusters; cent++) {
				float centroid[vector_size];
				//copy centroid to 1D array so can easily copy to kernel
				for (int i = 0; i < vector_size; i++) {
					centroid[i] = centroids[cent * vector_size + i];
				}

				//kernel variables: vectors, distances output, centroids
				float * d_vect;
				float * dist_out;
				float * d_cent;
				//storage for outputted distances

				float * ind_distances = new float[n_vectors * vector_size];
				//allocating memory
				cudaMalloc((void**)&d_vect, ARRAY_BYTES_VECTORS);
				cudaMalloc((void**)&d_cent, ARRAY_BYTES_CENTROIDS / clusters);
				cudaMalloc((void**)&dist_out, ARRAY_BYTES_DISTANCES);

				//copying variables to gpu
				cudaStatus = cudaMemcpy(d_vect, vectors, ARRAY_BYTES_VECTORS, cudaMemcpyHostToDevice);
				if (cudaStatus != cudaSuccess) {
					fprintf(stderr, "vectors memcpy to device failed");
					return cudaStatus;
				}

				cudaStatus = cudaMemcpy(d_cent, centroid, ARRAY_BYTES_CENTROIDS / clusters, cudaMemcpyHostToDevice);
				if (cudaStatus != cudaSuccess) {
					fprintf(stderr, "centroid memcpy to device failed");
					return cudaStatus;
				}

				//intiating kernel and computing distances per column, 1 block for each vector and 1 thread for each dimension
				dist << <vector_size, n_vectors >> > (dist_out, d_vect, d_cent);

				cudaStatus = cudaGetLastError();
				if (cudaStatus != cudaSuccess) {
					fprintf(stderr, "distance kernel launch failed: %s\n", cudaGetErrorString(cudaStatus));
					return cudaStatus;
				}
				//copying distances to cpu

				cudaStatus = cudaMemcpy(ind_distances, dist_out, ARRAY_BYTES_VECTORS, cudaMemcpyDeviceToHost);

				if (cudaStatus != cudaSuccess) {
					fprintf(stderr, "vectors memcpy to host failed");
					return cudaStatus;
				}

				cudaFree(d_vect);
				cudaFree(dist_out);
				cudaFree(d_cent);

				//kernel variables: summed distances output, column distances input
				float * d_dist_out;
				float * d_dist_in;
				//storage for summed distances
				float distances[n_vectors];

				//allocating memory
				cudaMalloc((void**)&d_dist_out, ARRAY_BYTES_DISTANCES / vector_size);
				cudaMalloc((void**)&d_dist_in, ARRAY_BYTES_VECTORS);

				cudaStatus = cudaMemcpy(d_dist_in, ind_distances, ARRAY_BYTES_VECTORS, cudaMemcpyHostToDevice);
				if (cudaStatus != cudaSuccess) {
					fprintf(stderr, "individual distances memcpy to device failed");
					return cudaStatus;
				}

				//summing the distances of individual columns, doing 1 vector per thread
				sumDist << <1, n_vectors >> > (d_dist_out, d_dist_in);
				cudaStatus = cudaGetLastError();
				if (cudaStatus != cudaSuccess) {
					fprintf(stderr, "summing distance kernel launch failed: %s\n", cudaGetErrorString(cudaStatus));
					return cudaStatus;
				}

				cudaStatus = cudaMemcpy(distances, d_dist_out, ARRAY_BYTES_VECTORS / vector_size, cudaMemcpyDeviceToHost);
				if (cudaStatus != cudaSuccess) {
					fprintf(stderr, "summed distances memcpy to host failed");
					return cudaStatus;
				}

				cudaFree(d_dist_out);
				cudaFree(d_dist_in);

				//if this is the first centroid and iteration then populating the dictionary with values
				if (first == true) {
					for (int d = 0; d < n_vectors; d++) {
						c_data data;
						data.cluster = 0;
						data.distance = distances[d];
						int id = IDs[n_vectors * vc + d];
						cluster_data[id] = data;
					}
					first = false;
				}

				//updating the dictionary if distances are closer
				else {
					for (int d = 0; d < n_vectors; d++) {
						if (distances[d] < cluster_data[IDs[n_vectors * vc + d]].distance) {
							int id = IDs[n_vectors * vc + d];
							cluster_data[id].distance = distances[d];
							cluster_data[id].cluster = cent;
						}
					}
				}

				free(ind_distances);
				cout << cent + 1 << " centroids processed" << endl;
			}

			//filling a flattened 2D array with vectors IDs/indexes grouped with their cluster
			//each row is length n_vectors batch and represents a different cluster
			int assignedClusters[clusters * n_vectors];
			int ends[clusters];
			std::fill_n(assignedClusters, clusters * n_vectors, -1);
			std::fill_n(ends, clusters, 0);
			for (int d = 0; d < n_vectors; d++) {
				int clust = cluster_data[IDs[n_vectors * vc + d]].cluster;
				assignedClusters[n_vectors * clust + ends[clust]] = d;
				ends[clust]++;
			}
			//kernel variables: updated centroids output, vectors, the number of vectors assigned to each cluster
			float * d_cent_out;
			int * d_vect_in;
			int * d_ends;
			int * d_cent_in;

			//allocating memory
			cudaMalloc((void**)&d_cent_out, ARRAY_BYTES_CENTROIDS / clusters);
			cudaMalloc((void**)&d_vect_in, ARRAY_BYTES_VECTORS);
			cudaMalloc((void**)&d_ends, sizeof(int) * clusters);
			cudaMalloc((void**)&d_cent_in, (ARRAY_BYTES_VECTORS / vector_size) * clusters);

			//copying variables to gpu
			cudaError_t cudaStatus = cudaMemcpy(d_cent_in, assignedClusters, (ARRAY_BYTES_VECTORS / vector_size) * clusters, cudaMemcpyHostToDevice);

			if (cudaStatus != cudaSuccess) {

				fprintf(stderr, "assigned centroids cudaMemcpy to device failed!");
				return cudaStatus;
			}

			cudaError_t cudaStatus = cudaMemcpy(d_vect_in, vectors, ARRAY_BYTES_VECTORS, cudaMemcpyHostToDevice);

			if (cudaStatus != cudaSuccess) {

				fprintf(stderr, "vectors cudaMemcpy to device failed!");
				return cudaStatus;
			}

			cudaError_t cudaStatus = cudaMemcpy(d_ends, ends, sizeof(int) * clusters, cudaMemcpyHostToDevice);

			if (cudaStatus != cudaSuccess) {

				fprintf(stderr, "index ends of clusters cudaMemcpy to host failed!");
				return cudaStatus;
			}

			//computing the mean of each of the 100 columns per centroids/cluster
			mean << <vector_size, clusters >> > (d_cent_out, d_vect_in, d_ends, d_cent_in);

			cudaStatus = cudaGetLastError();
			if (cudaStatus != cudaSuccess) {
				fprintf(stderr, "computing cluster means kernel launch failed: %s\n", cudaGetErrorString(cudaStatus));
				return cudaStatus;
			}

			//returning the new updated centroids
			cudaError_t cudaStatus = cudaMemcpy(centroids, d_cent_out, ARRAY_BYTES_CENTROIDS / clusters, cudaMemcpyDeviceToHost);

			//checking if copy is sucessful
			if (cudaStatus != cudaSuccess) {

				fprintf(stderr, "updated centroids cudaMemcpy to host failed!");
				return cudaStatus;
			}


			cudaFree(d_vect_in);
			cudaFree(d_ends);
			cudaFree(d_cent_in);
			cudaFree(d_cent_out);
			//free(vectors);
		}

	}
	return cudaStatus;
}
//2283mb per 100k

int main() {
	database_functions db;
	db.intialise_database();
	cout << "IDs retrieved from database" << endl;
	kmeans(db);
	return 0;
}







