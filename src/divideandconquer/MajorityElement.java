package divideandconquer;

import java.util.Arrays;

public class MajorityElement {
	public static void main(String[] args) {
		int[] a= {2,2,1,1,1,2,2};
		Arrays.sort(a);
		int n=a.length;
		
		int mid=(0+n-1)/2;
		int major=a[mid];
		int leftIndex=getLeft(a,0,mid,major);
		System.out.print(leftIndex);
		
		
	}

	private static int getLeft(int[] a, int s, int e,int major) {
		if(s<=e) {
			int mid=(s+e)/2;
			if(a[mid]==major) {
				if(mid==0|| a[mid-1]==major)
					return getLeft(a,s,mid,major);
				else
					return mid;
			}
			else
				return getLeft(a,mid+1,e,major);
		}
		
		return -1;
	}

}
