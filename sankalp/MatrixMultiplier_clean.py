import sys
import random

matrixDim = 1000
randomMaxValue = 100

matrixA = [[0 for i in range(matrixDim)] for j in range(matrixDim)]
matrixB = [[0 for i in range(matrixDim)] for j in range(matrixDim)]
matrixC = [[0 for i in range(matrixDim)] for j in range(matrixDim)]


for i in range (0, matrixDim):
	for j in range (0, matrixDim):

		matrixA[i][j] = random.randint(0, randomMaxValue)
		matrixB[i][j] = random.randint(0, randomMaxValue)


#for i in range(0, matrixDim):
#			for j in range(0, matrixDim):
#				for k in range (0, matrixDim):
#					matrixC[i][j] += matrixA[i][k] * matrixB[k][j] 
