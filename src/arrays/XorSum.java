package arrays;

public class XorSum {
	public static void main(String[] args) {
		int n=1;
		int res=(int) (Math.pow(2, n+1)-Math.pow(2,n-1));
		System.out.println(res+" ");	
	}
	private static void printAllSubset() {
		int n=3;
		for(int i=0;i<1<<n;i++) {
			System.out.println();
			for(int j=0;j<=n;j++) {
				if((i &(1<<j))>0)
					System.out.print(j+" ");
			}
		}
	}

}
