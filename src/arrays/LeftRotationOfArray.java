package arrays;

public class LeftRotationOfArray {
	public static void main(String[] args) {
		int [] a= {1,2,3,4,5,6};
		int d=2;
		System.out.println("\n"+"***********************approach1***********************");
		 int[] a1= {1,2,3,4,5,6};
		approach1(a1,d);
		System.out.println("\n"+"\n"+"*************************approach2 ***************************************");
		int [] a2= {1,2,3,4,5,6};
		approach2(a2,d);
		System.out.println("\n"+"\n"+"*******************************approach3**********************************");
		approach3(a,d);	
		System.out.println("\n"+"\n"+"*************************approach4 ***************************************");
		int [] a4= {1,2,3,4,5,6};
		approach4(a4,d);
		System.out.println("\n"+"\n"+"*************************approach5 ***************************************");
		int [] a5= {1,2,3,4,5,6};
		//approach5(a5,d);
		//System.out.println(gcd(5,7));
	}

//	private static void approach5(int[] a, int d) {
//		int n=a.length;
//		int part=gcd(n,d);
//		for(int i=0;i<part;i++) {
//			int temp=a[i];
//			while()
//			
//		}
//		
//	}

	private static int gcd(int n, int d) {
		if(n==0)return d;
		if(d==0) return n;
		if(n==d) return d;
		if(n>d)
			return gcd(n-d,d);
		else
			return gcd(n,d-n);
		
		
	}

	private static void approach4(int[] a, int d) {
		int b[] =new int[d];
		for(int i=0;i<d;i++)
			b[i]=a[i];
		int k=0;
		for(int i=0;i<a.length;i++) {
			if(i<a.length-d)
				a[i]=a[i+d];
			else
				a[i]=b[k++];
		}
		print(a);
		
		
		
	}

	private static void approach3(int[] a, int d) {
		int n=a.length;
		int[] b=new int[n];
		for(int i=0;i<n;i++) 
			b[i]=a[(i+d)%n];
		print(b);
		
		
	}

	private static void approach2(int[] a, int d) {
		
		reverse(a,0,d-1);
		reverse(a,d,a.length-1);
		reverse(a,0,a.length-1);
		
		
	}

	private static void reverse(int[] a, int l, int r) {
		for(int i=l;i<=r;i++,r--) {
			int temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
		//System.out.println();
		print(a);
		
	}

	private static void approach1(int[] a2, int d) {
		int [] a= {1,2,3,4,5,6};
		int j=0;
		while(j<d) {
			int temp=a[0];
			for(int i=0;i<a.length;i++) {
				
				if(i==a.length-1) {
					a[i]=temp;
				}
				else 
				a[i]=a[i+1];
			}
			j++;
		}
		print(a);		
	}

	private static void print(int[] a) {
		System.out.println();
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		
	}

}
