package sorting;

public class QuickSort {
	public static void main(String[] args) {
		int[] a= {9,6,5,0,8,2,4,7,0};
		quickSort(a,0,a.length-1);
		print(a);
	}

  private static void print(int[] a) {
    for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
	}
    System.out.println();
    
  }

	private static void quickSort(int[] a, int low, int high) {
		if(low<high) {
			int pi=partition(a,low,high);
			quickSort(a,low,pi-1);
			quickSort(a,pi+1,high);
		}
		
	}

	private static int partition(int[] a, int low, int high) {
		int i=low-1,x=a[high];
		for(int j=low;j<high;j++) {
			if(a[j]<x) {
				i++;
				if(i!=j)
				 swap(a,i,j);
			}
		}
		i++;
		swap(a,i,high);
		print(a); //step by step printing;
		return i;
	}

	private static void swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

}
