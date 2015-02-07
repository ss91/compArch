import java.util.*;

public class MatrixMultiplier {
	
	static int[][] matrixA;
	static int[][] matrixB;
	static int[][] matrixC;
	
	public MatrixMultiplier (int N) {
		
			matrixA = new int[N][N];
			matrixB = new int[N][N];
			matrixC = new int[N][N];
					
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
	
	

	public static void main(String[] args) {
		

		MatrixMultiplier multiplier = new MatrixMultiplier(Integer.parseInt(args[0]));
		multiplier.fillMatrixRandom();
		//multiplier.printInputMatrices();
		multiplier.multiplyMatrices();
		//multiplier.printResultMatrix();
	
		

	}

}

