import torch
import torch.nn as nn
import torch.nn.functional as F
from sklearn import datasets
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import normalize
from sklearn.metrics import accuracy_score

def main():
    data = import_iris()
   # data.x_train = (data.x_train - data.x_train.mean()) / (data.x_train.max() - data.x_train.min())
    x = torch.tensor(data.x_train, dtype = torch.float)
    y = torch.tensor(data.y_train, dtype = torch.long)
    test_x = torch.tensor(data.x_test, dtype = torch.float)
    test_y = torch.tensor(data.y_test, dtype=torch.long)
    model = Net(4, 4, 3, 0,0)
    model = run_network(1000, x, y, model)
    model.eval()
    y_pred = model(test_x)
    pred = y_pred.data.numpy()
    print("The testing accuracy is", (accuracy_score(test_y, np.argmax(pred, axis=1)))*100, "%")

def run_network(epochs, x, y, model):
    loss_func = torch.nn.CrossEntropyLoss()
    opt = torch.optim.RMSprop(model.parameters(), lr=0.005)
    for epoch in range(epochs):
        y_pred = model(x)

        loss = loss_func(y_pred, y)
        print('Epoch: ', epoch, ' Loss: ', loss.item())
        if(loss < 0.7):
            break
        opt.zero_grad()
        loss.backward()
        opt.step()
    model.eval()

    pred = y_pred.data.numpy()
    print("The training accuracy is", (accuracy_score(y, np.argmax(pred, axis=1)))*100, "%")

    return model
#def print_acc(y_pred, y):



def to_one_hot(labels, dimension):
    results = np.zeros((len(labels), dimension))
    for i, label in enumerate(labels):
        results[i, label] = 1.
    return results

def import_iris():
    iris = datasets.load_iris()
    x = np.asarray(iris.data)
    y = iris.target
    x_tr, x_te, y_tr, y_te = train_test_split(x, y, test_size= 0.33, shuffle = True)
    data = Data(x_tr, x_te, y_tr, y_te)
    return data

class Data():
    def __init__(self, x_tr, x_te, y_tr, y_te):
        self.x_train = x_tr
        self.y_train = y_tr
        self.x_test = x_te
        self.y_test = y_te

class Net(nn.Module):

    def __init__(self, d_in, h, d_out, l, p):
        super(Net, self).__init__()
        self.h = h
        self.in_layer = nn.Linear(d_in, h)
        self.layers = []
        self.out_layer = nn.Linear(h, d_out)
        self.drop_layer = nn.Dropout(p=p);
        self.add_layers(l)
        self.l = l
        self.d_out = d_out

    def add_layers(self, l):
        for i in range(l):
            self.layers.append(nn.Linear(self.h, self.h))

    def forward(self, x):
        out = F.relu(self.in_layer(x))
        #out = self.drop_layer(out)
        for i in range(self.l):
             out = self.layers[i](out)
        if(self.d_out == 1):
            y_pred = torch.sigmoid(self.out_layer(out))
        else:
            y_pred = F.softmax(self.out_layer(out))
        return y_pred


main()