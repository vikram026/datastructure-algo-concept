package divideandconquer;


//Total count of count of no's greater then its right;

public class InversionCount {
	//static int ic=0,k;
	static int[] res;
	public static void main(String[] args) {
		int[] a= {7,5,1,3,4,6};
		res=new int[a.length];
		int count=countInversion(a,0,a.length-1);
		System.out.println("count is -> "+count);
		print();
	}

	private static void print() {
		for(int e:res)
			System.out.print(e+" ");
		System.out.println();
		
	}

	private static int countInversion(int[] a, int l, int r) {
		//inversionCount ic
		int ic=0,mid;
		if(l<r) {
			mid=(l+r)/2;
			ic+=countInversion(a, l, mid);
			ic+=countInversion(a, mid+1, r);
			ic+=merge(a,l,mid,r);
			print();
			
			
		}
		
		return ic;
	}

	private static int merge(int[] a, int l, int mid, int r) {
		int ic=0,k=l;
		int i=l,j=mid+1;
		while(i<=mid && j<=r) {
			if(a[i]<=a[j]){
				res[k++]=a[i++];
			}
			else {
				res[k++]=a[j++];
				ic+=(mid-i+1);
			}
		}
		while(i<=mid) {
			res[k++]=a[i++];
		}
		while(j<=r) {
			res[k++]=a[j++];
		}
		for(i=l;i<=r;i++) {
			a[i]=res[i];
		}
		return ic;
	}

}
