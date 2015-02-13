#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

static int **matrixA;
static int **matrixB;
static int **matrixC;
static int N;

static int randomMaxValue = 100;

void setUpMatrices() {

	int i = 0;

	matrixA = malloc(sizeof(int *) * N);
	matrixB = malloc(sizeof(int *) * N);
	matrixC = malloc(sizeof(int *) * N);

	

	for (i=0 ; i<N; i++) {

		matrixA[i] = malloc(sizeof(int) * N);
		matrixB[i] = malloc(sizeof(int) * N);
		matrixC[i] = malloc(sizeof(int) * N);
	}

}

void fillMatrices() {

	srand(time(NULL));
	int i = 0;
	int j = 0;

	for (i=0; i<N; i++) {

		for (j=0; j<N; j++) {

			matrixA[i][j] = rand() % (randomMaxValue);
			matrixB[i][j] = rand() % (randomMaxValue);
		}


	}


}

void printInputMatrices() {

	int i = 0;
	int j = 0;

	for (i=0; i<N; i++) {

		for (j=0; j<N; j++) {

			printf(" %d ", matrixA[i][j]);

		}

		printf("\n");
	}

	for (i=0; i<N; i++) {

		for (j=0; j<N; j++) {

			printf(" %d ", matrixB[i][j]);

		}

		printf("\n");
	}

}

void multiplyMatrices() {

	int i = 0;
	int j = 0;
	int k = 0;

	for (i=0; i<N; i++) {

		for (j=0; j<N; j++) {

			for (k=0; k<N; k++) {

				matrixC[i][j] += matrixA[i][k]*matrixB[j][k];
			}


		}


	}
}


void printResultMatrix() {


	int i = 0;
	int j = 0;

	for (i=0; i<N; i++) {

		for (j=0; j<N; j++) {

			printf(" %d ", matrixC[i][j]);

		}

		printf("\n");
	}	



}

void cleanUp() {

	int i = 0;
	
	for (i=0; i<N; i++) {

		free(matrixA[i]);
		free(matrixB[i]);
		free(matrixC[i]);
	}

	free(matrixA);
	free(matrixB);
	free(matrixC);

}


int main (int argc, char* argv[]) {

	N = atoi(argv[1]);

	setUpMatrices();
	fillMatrices();
	//printInputMatrices();
	multiplyMatrices(); 
	//printResultMatrix();
	cleanUp();



}
