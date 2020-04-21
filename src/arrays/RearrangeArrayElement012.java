package arrays;
//sort 0,1,2 in array
public class RearrangeArrayElement012 {
	public static void main(String[] args) {
		int[] a= {0,0,2,2,1,0,0,1,1,2,2,2,2,0,1,0,2};
		int n=a.length;
		int start=0,end=n-1;
	
		
		int i=start;
		while(i<=end) {
			if(a[i]==0) {
				if(start!=i) {
					swap(a,start,i);
				}start++;i++;
			}
			else if(a[i]==1)i++;
			else {
				swap(a,i,end);
				end--;
			}
		}
		//Stream.of(a).flatMap(e->).forEach(System.out::println);
		for(int e:a) {
			System.out.print(e+" ");
		}	
	}

	private static void swap(int[] a, int start, int end) {
		int temp=a[start];
		a[start]=a[end];
		a[end]=temp;
	}
}
