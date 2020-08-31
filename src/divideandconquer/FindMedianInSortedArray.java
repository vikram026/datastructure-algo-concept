package divideandconquer;


//TODO 
public class FindMedianInSortedArray {
	public static void main(String[] args) {
		int[] a= {10,21,25,26};
		int[] b= {7,9,15,127};
		int median=findMedianInSortedArray(a,b,0,0,a.length-1,b.length-1);
		System.out.print("Median of given arrays are->   "+median+" ");
	}

	private static int findMedianInSortedArray(int[] a, int[] b, int ml, int nl, int mr,int nr) {

		if(mr-ml==1) return ( Math.max(a[ml], b[nl])+Math.min(a[mr], b[nr]))/2;
		int mid1=getMedian(a,ml,mr);
		int mid2=getMedian(b,nl,nr);
		if(mid1==mid2)return mid1;
		return (mid1<mid2)?
			 findMedianInSortedArray(a,b,(ml+mr+1)/2,nl,mr,(nl+nr+1)/2)
			 :findMedianInSortedArray(a,b,ml,(nl+nr+1)/2,(ml+mr+1)/2,nr);
	}

	private static int getMedian(int[] a, int ml, int mr) {
		int n=mr-ml+1;
		return (n%2==0)?(a[ml+n/2]+a[ml+n/2-1])/2:a[ml+n/2];
	}

}
