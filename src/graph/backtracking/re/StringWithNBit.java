package graph.backtracking.re;

import java.util.Arrays;

public class StringWithNBit {

	public static void main(String[] args) {
		char[] a = new char[3];
		Arrays.fill(a, '9');
		getStrings(a,0,3);
	}

	private static void  getStrings(char[] a,int l,int h) {
		if(l==h) {
			System.out.println(String.valueOf(a));
			return;
		}
		
		for(char i:Arrays.asList('0','1')) {
			a[l]=i;
			getStrings(a,l+1,h);
			a[l]=i;
		}
	}
	
}
