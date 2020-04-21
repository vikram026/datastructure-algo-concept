package arrays;

public class FindMin_Max {
	public static void main(String[] args) {
		
	
	int[] a= {6,4,5,3,8,9,10,5,3,11,2,14,7};
	int min=Integer.MAX_VALUE;
	int max=Integer.MIN_VALUE;
			
	for(int i=1;i<a.length;i=i+2) {
		if(a[i-1]<a[i]) {
			if(a[i-1]<min) {
				min=a[i-1];
			}
			if(a[i]>max) {
				max=a[i];
			}
			
		}
		else {
			if(a[i]<min) {
				min=a[i];
			}
			if(a[i-1]>max) {
				max=a[i-1];
			}
			
		}	
	}
	if(a.length%2!=0) {
		if(a[a.length-1]<min) {
			min=a[a.length-1];
		}
		if(a[a.length-1]>max) {
			max=a[a.length-1];
		}
	}
	
	System.out.println("min"+min+"  max="+max);
}
	
	
}
