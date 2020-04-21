package arrays;
//Print all the subset from the given array;
public class PrintAllTheSubset {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		printAllSubset(arr);
	}

	private static void printAllSubset(int[] arr) {
		int n=arr.length;
		for(int i=0;i<1<<n;i++) {
			System.out.println();
			for(int j=0;j<n;j++) {
				if((i &(1<<j))>0)
					System.out.print(arr[j]+" ");
			}
		}
	}
}
