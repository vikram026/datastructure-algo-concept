package recursion;

public class PermutaionOfElementsOfArray {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5};
		PermutaionOfElementsOfArray poeoa=new PermutaionOfElementsOfArray();
		poeoa.permutate(a,0,a.length);
	}

	private void permutate(int[] a, int k, int n) {
		if(k==n-1) {
			for(int element:a) 
				System.out.print(element+" ");
			System.out.println();
		}
		for(int i=k;i<n;i++) {
			swap(a,i,k);
			permutate(a,k+1,n);
			swap(a,i,k);
		}
	}

	private void swap(int[] a, int i, int k) {
		int temp=a[i];
		a[i]=a[k];
		a[k]=temp;
	}

}
