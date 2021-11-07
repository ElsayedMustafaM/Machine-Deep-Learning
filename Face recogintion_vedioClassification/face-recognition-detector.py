# -*- coding: utf-8 -*-
"""
Created on Tue Mar 13 04:17:52 2018

@author: ElSaYeDM
"""
import pandas as pd   
import numpy as np
import os
import cv2
import pickle, sqlite3

face_cascade = cv2.CascadeClassifier('C:/Users/ElSaYeDM/haarcascade_frontalface_default.xml')

eye_cascade = cv2.CascadeClassifier('C:/Users/ElSaYeDM/haarcascade_eye.xml')
recognizer = cv2.createLBPHFaceRecognizer()
recognizer.load("training_data.yml")

#To train using images captured or saved online
# img = cv2.imread("him.jpg")

def getProfile(Id):
    conn=sqlite3.connect("FaceBase.db")
    c=conn.cursor()
    query="SELECT * FROM People WHERE ID="+str(Id)
    c.execute(query)
    profile=None
    for row in c.fetchall():
        profile=row 
    conn.close()
    return profile

#to train using frames from video
cap = cv2.VideoCapture(0)
font = cv2.FONT_HERSHEY_PLAIN
while True:
    #comment the next line and make sure the image being read is names img when using imread
    ret, img = cap.read()
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.3, 5)
    for (x,y,w,h) in faces:

        cv2.rectangle(img, (x,y), (x+w, y+h), (0,255,0), 2)
        roi_gray = gray[y:y+h, x:x+w]
        roi_color = img[y:y+h, x:x+w]

        # Hiding the eye detector for now
        eyes = eye_cascade.detectMultiScale(roi_gray)
        for (ex, ey, ew, eh) in eyes:
            cv2.rectangle(roi_color, (ex, ey), (ex+ew, ey+eh), (255, 0, 0), 2)
        nbr_predicted, conf = recognizer.predict(gray[y:y+h, x:x+w])
        if conf < 70:
            profile=getProfile(nbr_predicted)
            if profile != None:
               
                    cv2.putText(img, "Name: "+str(profile[1]), (x, y+h+30), font, 1.5, (255,255, 255), 2);
        else:
            cv2.putText(img, "Name: Unknown", (x, y + h + 30), font, 1.5, (0, 0, 255), 2);

    cv2.imshow('img', img)
    if cv2.waitKey(3) == 48:
        break
cap.release()
cv2.destroyAllWindows()

