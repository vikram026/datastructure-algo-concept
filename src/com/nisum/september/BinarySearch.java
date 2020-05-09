package com.nisum.september;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a= {12,34,45,43,87,90};
		Arrays.sort(a);
		int key=45;
		int n=5;
		int l=0,r=n;
		while(l<=r) {
			int m= (l+r)/2;
			if(a[m]==key) {
				System.out.println("index of the key is="+m);l++;

			}
			   
			else if(a[m]<key)
				l=m+1;
			else
				r=m-1;
		}
	}

} 
