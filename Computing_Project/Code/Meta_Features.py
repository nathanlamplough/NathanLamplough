import pandas as pd
import numpy as np
import math


def compute_meta_features():
    data = read_data('C:/Users/natha\ThirdYear\Computing_Project\data/iris.csv', 'species');
    mf = Meta_Features
    mf.n_instances = len(data[0])
    mf.n_classes = len(np.unique(data[1]))
    mf.n_features = data[0].shape[1]
    mf.dimensionality = mf.n_instances/mf.n_features
    mf.mean_correlation = corr = data[2].corr().sum().sum()/(data[2].shape[1]*2)
    mf.mean_skewness = data[2].skew().sum()/(data[2].shape[1])
    mf.class_entropy = compute_entropy(data[1])
    mf.feature_entropy = compute_mean_feature_entropy(data[0])

def compute_mean_feature_entropy(x):
    sum_entropy = 0
    for i in range(x.shape[1]):
        sum_entropy = sum_entropy + compute_entropy(x[:,i])
    return sum_entropy/x.shape[1]

def compute_entropy(column):
    u, c = np.unique(column, return_counts=True)
    entro = ((c/c.sum())*np.log2(c/c.sum())).sum()
    return -entro;

def read_data(filepath, y_name):
    data = pd.read_csv(filepath, delimiter=',', quoting = 3)
    y = np.asarray(data[y_name])
    dfx = data.drop([y_name], axis = 1)
    x = np.asarray(data.drop([y_name], axis = 1))
    return (x,y, dfx)

class Meta_Features():
   def __init__(self, n, fea, c, dim, mean_col, mean_skew, mean_kurt, class_ent, fea_ent, mean_mi, max_mi, equ_fea, ns_r):
        self.n_instances = n
        self.n_features = fea
        self.n_classes = c
        self.dimensionality = dim
        self.mean_correlation = mean_col
        self.mean_skewness = mean_skew
        self.class_entropy = class_ent
        self.feature_entropy = fea_ent
        self.mean_mutual_info = mean_mi
        self.max_mutual_info = max_mi
        self.equiv_n_features = equ_fea
        self.noise_signal_ration = ns_r

compute_meta_features()