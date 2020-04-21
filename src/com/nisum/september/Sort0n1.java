package com.nisum.september;

public class Sort0n1 {
	public static void main(String[] args) {
		int[] a= {1,1,1,0,1,1,1};
		int l=0,r=a.length-1;
		while(l<r) {
			while(a[l]==0 && l<r) l++;
			while(a[r]==1 && l<r )r--;
			if(a[l]==1 && a[r]==0) {
				int temp=a[l];
				a[l]=a[r];
				a[r]=temp;
			}	
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}

}
