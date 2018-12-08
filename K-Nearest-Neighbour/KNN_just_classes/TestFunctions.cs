using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KNN
{
    class TestFunctions : Program
    {

        public static void PrintResults()
        {
            double [,] cm = ComputeConfusionMatrix();
           // double[,] cm = new double[,] { { 12288, 147 }, { 3136, 710 } };
            Console.WriteLine("Accuracy: " + ComputeAccuracy(cm));
            Console.WriteLine("Error: " + ComputeError(ComputeAccuracy(cm)));
            Console.WriteLine("Precision <=50K: " + ComputePrecision0(cm));
            Console.WriteLine("Precision >50K: " + ComputePrecision1(cm));
            Console.WriteLine("Sensitivity: <=50K: " + ComputeSensitivity0(cm));
            Console.WriteLine("Specifity: " + ComputeSpecificity(cm));
        }

        public static double[,] ComputeConfusionMatrix()
        {
            double [,] cm = new double[2, 2];
            //the total number of class 1 minus the number of class 1 incorrectly classified as class 2
            cm[0, 0] = c1Count - testErr[0];
            //the of class 1 incorrectly classified as class 2
            cm[0, 1] =  testErr[0];
            //the of class 2 incorrectly classified as class 1
            cm[1, 0] = testErr[1];
            //the total number of class 2 minus the number of class 1 incorrectly classified as class 1
            cm[1, 1] = c2Count - testErr[1];
            return cm;
        }
        public static double ComputeAccuracy(double [,] cm)
        {
            double acc = (cm[0, 0] + cm[1, 1]) / (cm[0, 0] + cm[1, 1] + cm[0, 1] + cm[1, 0]);
            return acc;
        }
        public static double ComputeError(double acc)
        {
            return 1 - acc;
        }
        public static double ComputePrecision0(double [,] cm)
        {
            double prec = cm[0, 0] / (cm[0, 0] + cm[1, 0]);
            return prec;
        }
        public static double ComputePrecision1(double[,] cm)
        {
            double prec = cm[1, 1] / (cm[1, 1] + cm[0, 1]);
            return prec;
        }
        public static double ComputeSensitivity0 (double [,] cm)
        {
            double sens = cm[0, 0] / (cm[0, 0] + cm[0, 1]);
            return sens;
        }
       
        public static double ComputeSpecificity(double [,] cm)
        {
            double spec = cm[1, 1] / (cm[1, 1] + cm[1, 0]);
            return spec;
        }

        public static void GetKErrors(Dictionary<AdultTest, TupleList<double, int>> distances, int split, int k)
        {
            foreach (KeyValuePair<AdultTest, TupleList<double, int>> d in distances)
            {
                if (d.Key.earns.Equals(" >50K"))
                {
                    CountError(d.Key, d.Value, 1, split, k);
                }
                else
                {
                    CountError(d.Key, d.Value, 0, split, k);
                }
            }
        }

        public static void TestK(List<AdultTest> split1, List<AdultTrain> split2, int split, int k)
        {
            Dictionary<AdultTest, TupleList<double, int>> distances = new Dictionary<AdultTest, TupleList<double, int>>();
            foreach (var a in split1)
            {
                if(a.earns.Equals(" >50K"))
                {
                    c2Count++;
                }
                else
                {
                    c1Count++;
                }
                TupleList<double, int> aDistances = new TupleList<double, int>();
                foreach (var b in split2)
                {
                    double dist = CalculateEuclideanDistance(a, b);
                    int label = 0;
                    if (b.earns.Equals(">50K"))
                    {
                        label = 1;
                    }
                    aDistances.Add(dist, label);
                }
                aDistances.Sort();
                distances.Add(a, aDistances);
            }

            GetKErrors(distances, split, k);
        }

        public static void CountError(AdultTest input, TupleList<double, int> distLabels, int inputLabel, int split, int k)
        {
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
                if (i == k)
                {
                    int label = 1;
                    if (lThan50.Count > gThan50.Count)
                    {
                        label = 0;
                    }
                    if (inputLabel != label)
                    {
                        testErr[inputLabel]++;
                    }
                }
                
                
                i++;
            }
        }

        public static double CalculateEuclideanDistance(AdultTest a, AdultTrain b)
        {
            List<double> dist = new List<double>();
            dist.Add(Square(a.age, b.age));
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

            foreach (var dis in dist)
            {
                sum += dis;
            }
            return Math.Sqrt(sum);
        }


    }
}
