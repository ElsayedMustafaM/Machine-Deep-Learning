import numpy as np
from flask import Flask, request, jsonify, render_template
#import   pickle
#from sklearn.externals import joblib 

from keras.models import load_model

# load model


app = Flask(__name__)

model = load_model('model.h5')
filename = 'model.pkl'
#with open(filename ,'rb') as f:
 #   model = pickle.load(f)

#model = joblib.load('model1.pkl')   

#model = pickle.load(open('model.pkl', 'rb'))

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/predict',methods=['POST'])
def predict():
    '''
    For rendering results on HTML GUI
    '''
    int_features = [int(x) for x in request.form.values()]
    final_features = np.array(int_features)
    final_features=final_features.reshape(1,2,5)

    prediction = model.predict(final_features)

    output = prediction[0]

    return render_template('index.html', prediction_text='Prediction is {} '.format(output[0]))

@app.route('/predict_api',methods=['POST'])
def predict_api():
    '''
    For direct API calls trought request
    '''
    data = request.get_json(force=True)
    data=np.array(list(data.values()))
    data=data.reshape(1,2,5)
    prediction = model.predict(data)

    output = prediction
    return jsonify(output)

if __name__ == "__main__":
    app.run(debug=True)
