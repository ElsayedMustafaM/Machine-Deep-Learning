# -*- coding: utf-8 -*-
"""
Created on Thu Dec 13 21:23:43 2018

@author: ElSayed
"""

from keras.models import Sequential
from keras.layers.convolutional import Conv2D
from keras.layers import MaxPooling2D
from keras.layers.core import Activation
from keras.layers.core import Flatten
from keras.layers.core import Dense




def build(width, height, depth, total_classes):
        # Initialize the Model
        model = Sequential()

        # First CONV => RELU => POOL Layer
        model.add(Conv2D(20, 5, 5, border_mode="same", input_shape=(depth, height, width)))
        model.add(Activation("relu"))
        model.add(MaxPooling2D(pool_size=(2, 2), strides=(2, 2), dim_ordering="th"))

        # Second CONV => RELU => POOL Layer
        model.add(Conv2D(50, 5, 5, border_mode="same"))
        model.add(Activation("relu"))
        model.add(MaxPooling2D(pool_size=(2, 2), strides=(2, 2), dim_ordering="th"))

        # Third CONV => RELU => POOL Layer
        # Convolution -> ReLU Activation Function -> Pooling Layer
        model.add(Conv2D(100, 5, 5, border_mode="same"))
        model.add(Activation("relu"))
        model.add(MaxPooling2D(pool_size=(2, 2), strides=(2, 2), dim_ordering="th"))

        # FC => RELU layers
        #  Fully Connected Layer -> ReLU Activation Function
        model.add(Flatten())
        model.add(Dense(500))
        model.add(Activation("relu"))

        # Using Softmax Classifier for Linear Classification
        model.add(Dense(total_classes))
        model.add(Activation("softmax"))

        
        return model
# --------------------------------- EOC ------------------------------------
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
import numpy as np
import cv2
import pandas as pd
from keras.utils import np_utils
from keras.optimizers import SGD
from sklearn.datasets import fetch_mldata
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder,OneHotEncoder
import matplotlib.pyplot as plt
from matplotlib import style
style.use('ggplot')
import sys
old_stdout = sys.stdout
log_file = open("summary.log","w")
sys.stdout = log_file





# Read/Download MNIST Dataset
data=pd.read_csv('emnist-letters-train.csv')

feature=data.iloc[:,1:].values.reshape((88799,28, 28))
label=data.iloc[:,0].values



# Divide data into testing and training sets.
train_img, test_img, train_labels, test_labels = train_test_split(feature/255.0, label, test_size=0.1)

# Now each image rows and columns are of 28x28 matrix type.
img_rows, img_columns = 28, 28

# Transform training and testing data to 26 classes 
total_classes = 26			# 0 to 25 labels

train_labels=train_labels.reshape(-1, 1)
test_labels=test_labels.reshape(-1, 1)
labelencoder=LabelEncoder()
train_labels[:,0]=labelencoder.fit_transform(train_labels[:,0])
onehot=OneHotEncoder(categorical_features=[0])
train_labels=onehot.fit_transform(train_labels).toarray()

labelencoder=LabelEncoder()
test_labels[:,0]=labelencoder.fit_transform(test_labels[:,0])
onehot=OneHotEncoder(categorical_features=[0])
test_labels=onehot.fit_transform(test_labels).toarray()

train_img=train_img.reshape(79919,1,28,28)
test_img=test_img.reshape(8880,1,28,28)


# Defing and compile the SGD optimizer and CNN model

print('\n Compiling model...')
sgd = SGD(lr=0.01, decay=1e-6, momentum=0.9, nesterov=True)
clf = build(width=28, height=28, depth=1, total_classes=26)
clf.compile(loss="categorical_crossentropy", optimizer=sgd, metrics=["accuracy"])

# Initially train and test the model; If weight saved already, load the weights using arguments.
b_size = 128		# Batch size
num_epoch = 20		# Number of epochs
verb = 1			# Verbose



print('\nTraining the Model...')
clf.fit(train_img, train_labels, batch_size=b_size, epochs=num_epoch,verbose=verb)
	
# Evaluate accuracy and loss function of test data
print('Evaluating Accuracy and Loss Function...')
loss, accuracy = clf.evaluate(test_img, test_labels, batch_size=128, verbose=1)
print('Accuracy of Model: {:.2f}%'.format(accuracy * 100))

	


import pickle
filename = 'final_model.sav'
pickle.dump(clf, open(filename, 'wb'))
	

filename = 'final_model.sav'
clf = pickle.load(open(filename, 'rb'))


test_labels_pred = clf.predict(test_img.reshape(8880,1,28,28))
# Show the Test Images with Original and Predicted Labels
a = np.random.randint(1,50,20)
for i in a:
    two_d = (np.reshape(test_img[i], (28, 28)) * 255).astype(np.uint8)
    
    prediction = test_labels_pred[i].argmax()

    plt.title('Original Label: {0}  Predicted Label: {1}'.format(test_labels[i],prediction))
    plt.imshow(two_d, interpolation='nearest',cmap='gray')
    plt.show()

#---------------------- EOC ---------------------    


    

    
    
    
    
    
    
