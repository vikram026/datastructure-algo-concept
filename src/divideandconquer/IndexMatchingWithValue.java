package divideandconquer;

public class IndexMatchingWithValue {
	public static void main(String[] args) {
		int[] a= {-2,-1,1,2,21};
		int index=findIndex(a,0,a.length-1);
		System.out.println(index);
	}
	
	private static int findIndex(int[] a, int l, int r) {
		
		if(l<=r) {
			int mid=(l+r)/2;
			if(mid==a[mid])return mid;
			else if(mid>a[mid])
				return findIndex(a,mid+1,r);
			return findIndex(a,l,mid-1);
		}
		return -1;
	}

}
