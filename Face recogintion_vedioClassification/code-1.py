import random

class Perceptron(object):
    count=0
    def __init__(self):
        self.weights=[]
        self.outputs=[]
        self.desired=[0, 0, 0, 1]
        self.input=[[0,0,1,1],[0,1,0,1]]
        self.bias=1
        self.error=0.1

    #Generate random numbers in range 0,1
    def rnd(self):
        return random.uniform(0,1)

    #For initializing bias and weights random
    def initialize(self):
        self.bias=self.rnd()
        self.weights = []                #important o ensure not append values on the previous generated ones
        for i in range(2):
            self.weights.append(self.rnd())

    #Activation Fun
    def step_fun(self,net):
        if(net>0.5):
            return 1
        else:
            return 0

    #include calculation som of product and applying step function
    def neuron(self):
        print("*Lets start learning*")
        self.outputs = []              #important o ensure not append values on the previous generated ones
        for i in range(4):             #dimension of features (no. of different values of inputs)
            net=0
            for j in range(2):         # no. of inputs (x1, x2)
                net += self.weights[j] * self.input[j][i]            # calculation of net value(sum of product (input value * weight))

            self.outputs.append(self.step_fun(net+self.bias))        #apply activation function and fill output list
            print("**Net: " , net , "**output: " , self.outputs[i])
        print("///////////end of iteration///////////////")

    #start learning
    def start_learn(self):
        print("*****start learning************")
        while(self.error !=0):
            self.error=0
            self.initialize()
            self.neuron()
            for i in range(4):
                self.error += self.desired[i] - self.outputs[i]
            Perceptron.count+=1
            print(" Error: " , self.error, "in iteration ", Perceptron.count)
        print("///////////END////////////////")

P = Perceptron()
P.start_learn()













