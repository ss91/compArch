import sys
import random
class MatrixMultiplier:
	matrixA = [[]]
	matrixB = [[]]
	matrixC = [[]]

	matrixDim = 0
	randomMaxValue = 100
	def __init__(self, N):
		self.matrixDim = int(N)

		self.matrixA = [[0 for i in range(self.matrixDim)] for j in range(self.matrixDim)]
		self.matrixB = [[0 for i in range(self.matrixDim)] for j in range(self.matrixDim)]
		self.matrixC = [[0 for i in range(self.matrixDim)] for j in range(self.matrixDim)]

	def fillMatrices(self):
		
		i = 0
		j = 0

		for i in range (0, self.matrixDim):
			for j in range (0, self.matrixDim):

				self.matrixA[i][j] = random.randint(0, self.randomMaxValue)
				self.matrixB[i][j] = random.randint(0, self.randomMaxValue)

	
	def printInputMatrices(self):
		i = 0
		j = 0

		for i in range (0, self.matrixDim):
			for j in range (0, self.matrixDim):
				print " " + str(self.matrixA[i][j]) + " ",
			
			print "\n"

		for i in range (0, self.matrixDim):
			for j in range (0, self.matrixDim):

				print " " + str(self.matrixB[i][j]) + " ",
			
			print "\n"	

	def multiplyMatrices(self):
		
		for i in range(0, self.matrixDim):
			for j in range(0, self.matrixDim):
				for k in range (0, self.matrixDim):
					self.matrixC[i][j] += self.matrixA[i][k] * self.matrixB[k][j] 		


	def printOutputMatrix(self):

		for i in range (0, self.matrixDim):
			for j in range (0, self.matrixDim):

				print " " + str(self.matrixC[i][j]) + " ",
			
			print "\n"	



def main():
	multiplier = MatrixMultiplier(str(sys.argv[1]))
	multiplier.fillMatrices()
	#multiplier.printInputMatrices()
	multiplier.multiplyMatrices()
	#multiplier.printOutputMatrix()

if __name__ == "__main__":
	main()
