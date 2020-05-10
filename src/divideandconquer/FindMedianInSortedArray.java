package divideandconquer;

public class FindMedianInSortedArray {
	public static void main(String[] args) {
		int[] a= {10,21,25,26};
		int[] b= {7,9,15,127};
//		int a[] = { 1, 2, 3, 6 }; 
//		int b[] = { 4, 6, 8, 10 };
		int median=findMedianInSortedArray(a,b,0,0,a.length-1,b.length-1);
		System.out.print("Median of given arrays are->   "+median+" ");
	}

	private static int findMedianInSortedArray(int[] a, int[] b, int ml, int nl, int mr,int nr) {

		//if(mr-ml==0)return (a[0]+b[0])/2;
		if(mr-ml==1) return ( Math.max(a[ml], b[nl])+Math.min(a[mr], b[nr]))/2;
		
		int mid1=getMedian(a,ml,mr);
		int mid2=getMedian(b,nl,nr);
		
		
		if(mid1==mid2)return mid1;
		//int n=mr-ml+1;
		if(mid1<mid2) {
			
			return findMedianInSortedArray(a,b,(ml+mr+1)/2,nl,mr,(nl+nr+1)/2);
					
			
			
		}
		return findMedianInSortedArray(a,b,ml,(nl+nr+1)/2,(ml+mr+1)/2,nr);
	}

	private static int getMedian(int[] a, int ml, int mr) {
		int n=mr-ml+1;
		return (n%2==0)?(a[ml+n/2]+a[ml+n/2-1])/2:a[ml+n/2];
	}

}
