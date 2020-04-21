package sorting;

public class MergeSortImpl {

	public static void main(String[] args) {
		MergeSortImpl ms=new MergeSortImpl();
		
		int[] a= { 3,6,5,4,7,8,90,54,67,87 };
		ms.mergeSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+" ");

		}
	}
	private  void mergeSort(int[] a,int l,int r) {
		if(l<r) {
			int mid=(l+r)/2;
			mergeSort(a,l,mid);
			mergeSort(a,mid+1,r);
			merge(a,l,mid,r);
		}
	}

	private  void merge(int[] a, int l, int mid, int r) {
		int n1=mid-l+1;
		int n2=r-mid;
		
		int[] left=new int[n1];
		int[] right=new int[n2];
		
		for(int i=0;i<n1;i++)
			left[i]=a[i+l];
		for(int i=0;i<n2;i++)
			right[i]=a[i+mid+1];
		int i=0,j=0,k=l;
		while(i<n1 &&j<n2) {
			if(left[i]<=right[j])
				a[k++]=left[i++];
			else 
				a[k++]=right[j++];
		}
		while(i<n1)
			a[k++]=left[i++];
		while(j<n2) {
			a[k++]=right[j++];
		}
	}

}
