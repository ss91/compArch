import java.util.Random;


public class MtMult implements Runnable {
	public static int[][] a,b,c;
	public int count=0;
	public static int N,ct;
	
	public MtMult(int[] k) {
		this.count=ct;
		ct++;
		int l=0;
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				
				c[this.count][i]+=k[j]*b[j][l];
			}
			l++;
		}
	}
	
	public void run() {
		
	}
	
	public static void load() {
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++) {
				a[i][j] = Math.abs(new Random().nextInt() % 10);
				b[i][j] =  Math.abs(new Random().nextInt() % 10);
			}
		}
	}
	
	public static void printMat() {
		for(int i=0;i<N;i++) {
			System.out.println();
			for(int j=0;j<N;j++) {
				System.out.print(a[i][j] + " ");
			}
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<N;i++) {
			System.out.println();
			for(int j=0;j<N;j++) {
				System.out.print(b[i][j] + " ");
			}
		}
		System.out.println();
	}
	
	public static void printMatc() {
		for(int i=0;i<c.length;i++){
			System.out.println();
			for(int j=0;j<c.length;j++){
				System.out.print(c[i][j]+" ");
			}
		}
		System.out.println();
	}
	
	public static void main(String args[]) throws InterruptedException {
	    N = Integer.parseInt(args[0]);
		a = new int[N][N];
		b = new int[N][N];
		c = new int[N][N];
		load();
		
		printMat();
		
		for(int i=0;i<N;i++) {
			new Thread(new MtMult(a[i])).start();
		}
		Thread.sleep(10);
		
		printMatc();
	}
}
