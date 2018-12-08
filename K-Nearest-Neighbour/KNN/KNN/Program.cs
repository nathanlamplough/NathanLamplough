using Microsoft.VisualBasic.FileIO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CsvHelper;
using System.IO;

namespace KNN
{
    class Program
    {
        //0 is <=50k 1 > 50k
        public static Dictionary<int, List<int>> kAccs = new Dictionary<int, List<int>>();
        public static Dictionary<int, int> testErr = new Dictionary<int, int>() { { 0, 0 }, { 1, 0 } };
        public static int c1Count = 0;
        public static int c2Count = 0;
        public static Dictionary<int, double> kErr = new Dictionary<int, double>();
        public static List<int> foldCounts = new List<int>( new int[5]);
        public static int bestK = 1;
        static void Main(string[] args)
        {
            List<AdultTrain> train = ReadTrainCSV("adult.train.5fold.csv");
            List<AdultTest> test = ReadTestCSV("adult.test.csv");
      //Uncomment to peform cross validation
            //for (int i = 1; i < 40; i++)
            //{
            //    if (i % 2 != 0)
            //    {
            //        kAccs.Add(i, new List<int>(new int[5]));
            //    }
            //}

            //for (int j = 1; j < 6; j++)
            //{
            //    SplitData(j, train);
            //}
            //OutputAccuracy();

            TestFunctions.TestK(test, train, -1, 15);
            TestFunctions.PrintResults();
        }

        public static List<AdultTrain> ReadTrainCSV(string fileName)
        {
            string folder = @"C:\Users\natha\source\repos\KNN\KNN\Data\";
            TextReader textReader = File.OpenText(folder + fileName);
            var csv = new CsvReader(textReader);
            var records = csv.GetRecords<AdultTrain>().ToList();
            return records;
                    
        }
        public static List<AdultTest> ReadTestCSV(string fileName)
        {
            string folder = @"C:\Users\natha\source\repos\KNN\KNN\Data\";
            TextReader textReader = File.OpenText(folder + fileName);
            var csv = new CsvReader(textReader);
            var records = csv.GetRecords<AdultTest>().ToList();
            return records;
        }

        public static void OutputAccuracy()
        {
            foreach(KeyValuePair<int, List<int>> acc in kAccs)
            {
                double error = (GetAverageError(acc.Value));
                kErr.Add(acc.Key, error);
            }
            double lError = int.MaxValue;
            int bestK = 0;
            foreach(KeyValuePair<int, double> k in kErr)
            {
                if(k.Value < lError)
                {
                    bestK = k.Key;
                    lError = k.Value;
                }
                File.AppendAllText(@"C:\Users\natha\source\repos\KNN\KNN\Data\grid.results.txt", k.Key + " " + k.Value + Environment.NewLine);
            }
            Console.WriteLine("The best value for K is: " + bestK + " With an error of: " + lError);
        }

        public static double GetAverageError(List<int> errors)
        {
            double accSum = 0;
            for(int i = 0; i < errors.Count; i++)
            {
                accSum += (double)errors[i] / foldCounts[i];
            }
            double accAvg = accSum / errors.Count;
            return accAvg;
        }

        public static void SplitData(int split, List<AdultTrain> trainData)
        {           
            List<AdultTrain> split1 = new List<AdultTrain>();
            List<AdultTrain> split2 = new List<AdultTrain>();
            foreach(var instance in trainData)
            {
                if(instance.fold == split)
                {
                    split1.Add(instance);
                }
                else
                {
                    split2.Add(instance);
                }
            }
            foldCounts[split - 1] = split1.Count();
            TestK(split1, split2, split, -1);
        }

        public static void TestK(List<AdultTrain> split1, List<AdultTrain> split2, int split, int k)
        {
            //dictionary storing tested instances as a key and all their distances to every instance 
            //in the training set with their lable as the value
            Dictionary<AdultTrain, TupleList<double, int>> distances = new Dictionary<AdultTrain, TupleList<double , int>>();
            foreach(var a in split1)
            {
                TupleList<double, int> aDistances = new TupleList<double, int>();
                foreach(var b in split2)
                {
                    double dist = CalculateEuclideanDistance(a, b);
                    int label = 0;
                    if (b.earns.Equals(">50K"))
                    {
                        label = 1;
                    }
                    aDistances.Add(dist, label);
                }
                //here I sort the distances so I can easily take the top K distances
                aDistances.Sort();
                distances.Add(a, aDistances);
            }
            
            GetKErrors(distances, split, k);
        }

        public static void GetKErrors(Dictionary<AdultTrain, TupleList<double, int>> distances, int split, int k)
        {
           foreach(KeyValuePair<AdultTrain, TupleList<double,int>> d in distances)
            {
                //here I am calling count error with the test instances label as a parameter so I can
                //check if the top K give the correct classification
                if (d.Key.earns.Equals(">50K")){
                    CountError(d.Key, d.Value, 1, split, k);
                }
                else
                {
                    CountError(d.Key, d.Value, 0, split, k);
                }
            }
        }

        public static void CountError(AdultTrain input, TupleList<double, int> distLabels, int inputLabel, int split, int k)
        {
            //in this class I loop through the sorted distances and add all distances labelled <=50K and >50K
            //to seperate lists, then when i equals a desired tested K, I classify the test instance as the class list
            //with more distances, I then increment the number of errors in the current fold for the K if the test instance was incorrectly classified
            int i = 1;
            List<double> lThan50 = new List<double>();
            List<double> gThan50 = new List<double>();
          
            foreach (var dl in distLabels)
            {
                if (dl.Item2 == 0)
                {
                    lThan50.Add(dl.Item1);
                }
                else
                { 
                    gThan50.Add(dl.Item1);
                }
                    if (i % 2 != 0 && i != 0)
                    {
                        int label = 1;
                        if (lThan50.Count > gThan50.Count)
                        {
                            label = 0;
                        } 
                        if (inputLabel != label)
                        {
                            kAccs[i][split - 1]++;
                        }
                    }
                    if (i == 39)
                        break;
                
             
                 i++;
            }
        }
        
        public static int GetClosestAvg(List<double> lThan50, List<double> gThan50)
        {
            double lThan50Sum = 0;
            double gThan50Sum = 0;
            for(int i =0; i < lThan50.Count; i++)
            {
                lThan50Sum += lThan50[i];
                gThan50Sum += gThan50[i];
            }
            if (lThan50Sum > gThan50Sum)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }

        public static double CalculateEuclideanDistance(AdultTrain a, AdultTrain b)
        {
            List<double> dist = new List<double>();
            //here I am adding the squared difference between the instance variables in a (the test instance)
            //and b (the training instance) to a list
            dist.Add(Square(a.age,b.age));
            dist.Add(Square(1, Match(a.workclass, b.workclass)));
            dist.Add(Square(a.fnlwgt, b.fnlwgt));
            dist.Add(Square(1, Match(a.education, b.education)));
            dist.Add(Square(a.educationNum, b.educationNum));
            dist.Add(Square(1, Match(a.maritalStatus, b.maritalStatus)));
            dist.Add(Square(1, Match(a.occupation, b.occupation)));
            dist.Add(Square(1, Match(a.relationship, b.relationship)));
            dist.Add(Square(1, Match(a.race, b.race)));
            dist.Add(Square(1, Match(a.sex, b.sex)));
            dist.Add(Square(a.capitalGain, b.capitalGain));
            dist.Add(Square(a.capitalLoss, b.capitalLoss));
            dist.Add(Square(a.hoursPerWeek, b.hoursPerWeek));
            dist.Add(Square(1, Match(a.nativeCountry, b.nativeCountry)));

            double sum = 0;
            //here I am summing all the squared distances together
            foreach(var dis in dist)
            {
                sum += dis;
            }
            //here I am calculating the square root of the sum and returning it which is the
            //euclidean distance
            return Math.Sqrt(sum);
        }      

        public static double Square (double a, double b)
        {
            return Math.Pow((a - b), 2);
        }

        public static double Match (string a, string b)
        {
            if (a.Equals(b))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}
