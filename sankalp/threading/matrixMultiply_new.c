#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <pthread.h>
#include <unistd.h>

#define RANDOM_MAX_VALUE 10

static int **matrixA;
static int **matrixB;
static int **matrixC;
static int N;

struct threadArguments {

	int row;
	int column;
};

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

			matrixA[i][j] = rand() % RANDOM_MAX_VALUE;
			matrixB[i][j] = rand() % RANDOM_MAX_VALUE;
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

				matrixC[i][j] += matrixA[i][k]*matrixB[k][j];
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

void *multiplier(void *data) {

	int i = 0;
	
	struct threadArguments *threadArgs = (struct threadArguments *)data;

	int currentRow = threadArgs->row;
	int currentColumn = threadArgs->column;
	

	for (i=0; i<N; i++) {

		matrixC[currentRow][currentColumn] += matrixA[currentRow][i] * matrixB[i][currentColumn];

	}

	return NULL;

}


int main (int argc, char* argv[]) {

	N = atoi(argv[1]);
	int i = 0;
	int j = 0;

	pthread_t **thread;
	thread = malloc(sizeof(pthread_t *) * N);

	for (i = 0; i<N; i++) {

		thread[i] = malloc(sizeof(pthread_t) * N);

	}

	
	struct threadArguments **threadArgs;

	threadArgs = malloc(sizeof(struct threadArguments *) * N);

	for (i = 0; i<N; i++) {

		threadArgs[i] = malloc(sizeof(struct threadArguments) * N);


	}

	setUpMatrices();
	fillMatrices();
	//printInputMatrices();
		
	for (i=0; i<N; i++) {

				
		for (j=0; j<N; j++) {

			threadArgs[i][j].row = i;
			threadArgs[i][j].column = j;
			pthread_create (&thread[i][j], NULL, multiplier, &threadArgs[i][j]); 				

		}

	}


	for (i=0; i<N; i++) {

		for (j=0; j<N; j++) {

			pthread_join (thread[i][j], NULL);
		}
	}	

	for (i=0; i<N; i++) {

		free(thread[i]);
		free(threadArgs[i]);
	}

	
	free(thread);
	free(threadArgs);
	
	//printResultMatrix();
	cleanUp();

	return 0;

}
