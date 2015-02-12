import sys
import random
import threading
from threading import Thread

matrixDim = int(sys.argv[1])
randomMaxValue = 100
t1 = [0 for i in range(matrixDim)]

## INITIALISING MATRICES A B C

matrixA = [[0 for i in range(matrixDim)] for j in range(matrixDim)]
matrixB = [[0 for i in range(matrixDim)] for j in range(matrixDim)]
matrixC = [[0 for i in range(matrixDim)] for j in range(matrixDim)]

for i in range (0,matrixDim):
    for j in range (0,matrixDim):
        
        matrixA[i][j] = random.randint(0, randomMaxValue)
        matrixB[i][j] = random.randint(0, randomMaxValue)

## DEFINING THREAD

def MyThread1(arg):
   

    for j in range(0,matrixDim):
        for k in range (0,matrixDim):
            matrixC[arg][j] += matrixA[arg][k] * matrixB[k][j]



    pass

def printMat():
    for i in range (0, matrixDim):
        print "\n"
        for j in range (0,matrixDim):
            print str(matrixC[i][j]) + " ",


for i in range (0,matrixDim):
    t1[i] = threading.Thread(target=MyThread1, args=(i, ))
    t1[i].start()
    
for i in range (0,matrixDim):
    t1[i].join()
