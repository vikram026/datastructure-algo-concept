package arrays;

import java.util.Arrays;
//find the triplet sum of the array;
public class TripletSum {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7,8,9};
		int n=a.length;
		int sum=16;
		Arrays.sort(a);//sort the elements first;
		for(int i=0;i<n;i++) {
			sum=16-a[i];
			int l=i;
			int r=n-1;
			while(l<r){
				if(sum==a[l]+a[r]){
					System.out.println("Triplets for Sum 16 are :" +a[i]+" ,"+a[l]+", "+a[r]);l++;
					//return;
					//l++;
				}
				else if(sum>a[l]+a[r])
					l++;
				else
					r--;
			}
			
		}
		
	}

}
