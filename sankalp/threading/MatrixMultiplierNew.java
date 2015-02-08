
import java.util.*;

public class MatrixMultiplierNew {
	
	static int[][] matrixA;
	static int[][] matrixB;
	static int[][] matrixC;
	
	static int matrixDimension; 
	
	public MatrixMultiplierNew (int N) {
		
			matrixA = new int[N][N];
			matrixB = new int[N][N];
			matrixC = new int[N][N];
			matrixDimension = N;
					
	}
	
	public MatrixMultiplierNew () {
		
	}
	
	public void fillMatrixRandom() {
		

		Random rn = new Random();
		
		
		int i = 0;
		int j = 0;
		
		for (i=0; i<matrixA.length; i++) {
			
			for (j=0; j<matrixA.length; j++) {
				
				matrixA[i][j] = rn.nextInt(matrixA.length*10);
				matrixB[i][j] = rn.nextInt(matrixA.length*10);
				
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
	
	
	static class ThreadMultiply extends MatrixMultiplierNew implements Runnable {
		
		public ThreadMultiply(MatrixMultiplierNew threadMultiplier, int currentRow, int currentCol) {
			
			this.threadMultiplier = threadMultiplier;
			this.currentRow = currentRow;
			this.currentCol = currentCol;
		}
		
		MatrixMultiplierNew threadMultiplier;
		int currentRow;
		int currentCol;
		public void run () {
			
			
			int i = 0;
			int j = 0;
			
			for(i = 0; i < MatrixMultiplierNew.matrixDimension; i++) {
				
				matrixC[currentRow][currentCol] += matrixA[currentRow][i] * matrixB[i][currentCol];
					
						
				
			}
			
			
			
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		MatrixMultiplierNew multiplier = new MatrixMultiplierNew(Integer.parseInt(args[0]));
		multiplier.fillMatrixRandom();
		
		ThreadMultiply[][] threadMultiplier = new ThreadMultiply[multiplier.matrixDimension][multiplier.matrixDimension];
		Thread[][] t = new Thread[multiplier.matrixDimension][multiplier.matrixDimension];
		
		
		
		int i = 0;
		int j = 0;
		for (i = 0; i<multiplier.matrixDimension; i++) {
			for (j=0; j<multiplier.matrixDimension; j++) {
			
			
				
			threadMultiplier[i][j] = new MatrixMultiplierNew.ThreadMultiply(multiplier, i, j);
			t[i][j] = new Thread(threadMultiplier[i][j]);
			t[i][j].start();
		
			}
		}
		
		for (Thread[] temp_row: t) {
			for(Thread temp: temp_row) {
			
				temp.join();
			}
		}
		
	
	}

}


