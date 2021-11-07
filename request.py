import requests

url = 'http://localhost:5000/predict_api'
r = requests.post(url,json={'Volume(t-1)':1, 'Close(t-1)':1, 'open(t-1)':6,'high(t-1)':1, 'low(t-1)':1, 'Volume':6,'Close':1, 'open':1, 'high':6,'low':1, })

print(r.json())
