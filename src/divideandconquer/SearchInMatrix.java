package divideandconquer;

public class SearchInMatrix {
	public static void main(String[] args) {
		
		int[][] a= { { 0,2},
					{ 1,3}
				};
		int key=5;
		search(a,key);
	}

	private static void search(int[][] a, int key) {
		int m=a.length;
		if(m==0) {
			System.out.println("empty array");
			return;
		}
		int n=a[0].length;
		int i=0,j=n-1;
		while(i<n && j>=0) {
			if(a[i][j]==key) {
				System.out.println("key is found at x: "+i+" y: "+j);
				return;
			}
			else if(a[i][j]>key)
				j--;
			else
				i++;
		}
		
		System.out.println("Note Found search whole");	
		return;
	}

}
