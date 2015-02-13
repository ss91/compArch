import java.util.*;

public class MatrixMultiplier {
	
	static int[][] matrixA;
	static int[][] matrixB;
	static int[][] matrixC;
	
	static int matrixDimension; 
	
	public MatrixMultiplier (int N) {
		
			matrixA = new int[N][N];
			matrixB = new int[N][N];
			matrixC = new int[N][N];
			matrixDimension = N;
					
	}
	
	public MatrixMultiplier () {
		
	}
	
	public void fillMatrixRandom() {
		

		Random rn = new Random();
		
		
		int i = 0;
		int j = 0;
		
		for (i=0; i<matrixA.length; i++) {
			
			for (j=0; j<matrixA.length; j++) {
				
				matrixA[i][j] = rn.nextInt(10);
				matrixB[i][j] = rn.nextInt(10);
				
			}
			
		}
	}
	
	
	public void printInputMatrices() {
		
		int i = 0;
		int j = 0;
		
		for (i=0; i<matrixA.length; i++) {
			
			for (j=0; j<matrixA.length; j++) {
				
				System.out.print(" " + matrixA[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
		
		for (i=0; i<matrixA.length; i++) {
			
			for (j=0; j<matrixA.length; j++) {
				
				System.out.print(" " + matrixB[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
	}
	
	public void multiplyMatrices() {
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		for (i=0; i<matrixA.length; i++) {
			
			for (j=0; j<matrixA.length; j++) {
				
				for (k=0; k<matrixA.length; k++) {
					
					matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
					
				}
				
				
			}
			
			
		}
		
		
		
	}
	
	public void printResultMatrix() {
		
		int i = 0;
		int j = 0;
		
		for (i=0; i<matrixA.length; i++) {
			
			for (j=0; j<matrixA.length; j++) {
				
				System.out.print(" " + matrixC[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
		
		
		
	}
	
	
	static class ThreadMultiply extends MatrixMultiplier implements Runnable {
		
		public ThreadMultiply(MatrixMultiplier threadMultiplier, int currentRow) {
			
			this.threadMultiplier = threadMultiplier;
			this.currentRow = currentRow;
		}
		
		MatrixMultiplier threadMultiplier;
		int currentRow;
		
		public void run () {
			
			int i = 0;
			int j = 0;
			
			for(i = 0; i < MatrixMultiplier.matrixDimension; i++) {
				for(j=0; j<MatrixMultiplier.matrixDimension; j++) {
					
					matrixC[currentRow][i] += matrixA[currentRow][j] * matrixB[j][i];
					
				}
				
				
			}
			
			
			
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		MatrixMultiplier multiplier = new MatrixMultiplier(Integer.parseInt(args[0]));
		multiplier.fillMatrixRandom();

		ThreadMultiply[] threadMultiplier = new ThreadMultiply[multiplier.matrixDimension];
		Thread[] t = new Thread[multiplier.matrixDimension];		
		
		int i = 0;
		
		for (i = 0; i<multiplier.matrixDimension; i++) {
			
		threadMultiplier[i] = new MatrixMultiplier.ThreadMultiply(multiplier, i);
		t[i] = new Thread(threadMultiplier[i]);
		t[i].start();
				
		}
		
		for (Thread temp: t) {
			
			temp.join();
		}
		
	}

}
