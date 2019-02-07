import pandas as pd
import numpy as np
import math
from scipy import stats as stats
from sklearn.metrics import mutual_info_score as mi

def compute_meta_features():
    data = read_data('C:/Users/natha\ThirdYear\Computing_Project\data/iris.csv', 'species');
    mf = Meta_Features(data)

def read_data(filepath, y_name):
    data = pd.read_csv(filepath, delimiter=',', quoting = 3)
    y = np.asarray(data[y_name])
    dfx = data.drop([y_name], axis = 1)
    x = np.asarray(data.drop([y_name], axis = 1))
    return (x,y, dfx)

class Meta_Features():
   def __init__(self, data):
        self.n_instances = len(data[0])
        self.n_features = data[0].shape[1]
        self.n_classes = len(np.unique(data[1]))
        self.dimensionality = self.n_instances / self.n_features
        self.mean_correlation = data[2].corr().sum().sum()/(data[2].shape[1]*2)
        self.mean_skewness = data[2].skew().sum()/(data[2].shape[1])
        self.mean_kurtosis = stats.kurtosis(data[0]).sum()/(data[0].shape[1])
        self.class_entropy = self.compute_entropy(data[1])
        self.feature_entropy = self.compute_mean_feature_entropy(data[0])
        self.mean_mutual_info, self.max_mutual_info  = self.compute_mutual_info(data[0], data[1])
        self.equiv_n_features = self.class_entropy / self.mean_mutual_info
        self.noise_signal_ratio = (self.feature_entropy - self.mean_mutual_info) / self.mean_mutual_info

   def compute_mean_feature_entropy(self, x):
       sum_entropy = 0
       for i in range(x.shape[1]):
           sum_entropy = sum_entropy + self.compute_entropy(x[:, i])
       return sum_entropy / x.shape[1]

   def compute_entropy(self, column):
       u, c = np.unique(column, return_counts=True)
       entro = ((c / c.sum()) * np.log2(c / c.sum())).sum()
       return -entro;

   def compute_mutual_info(self, x, y):
       m_infos = []
       for i in range(x.shape[1]):
           m_infos.append(mi(x[:, i], y))
       mean_mi = sum(m_infos) / x.shape[1]
       max_mi = max(m_infos)
       return (mean_mi, max_mi)


compute_meta_features()