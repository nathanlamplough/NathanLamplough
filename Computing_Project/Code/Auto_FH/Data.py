from sklearn.model_selection import train_test_split

def Split_Data(X, Y, s):
    x_tr, x_te, y_tr, y_te = train_test_split(X, Y, test_size=s, shuffle=True)
    data = Data(x_tr, x_te, y_tr, y_te)
    return data


class Data():
    def __init__(self, x_tr, x_te, y_tr, y_te):
        self.x_train = x_tr
        self.y_train = y_tr
        self.x_test = x_te
        self.y_test = y_te