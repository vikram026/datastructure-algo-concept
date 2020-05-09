package com.nisum.september;


public class StringPermutation {
	public static void main(String[] args) {
		permuteDistinct("AAC",0,2);
	}


	private static void permuteDistinct(String string, int l, int r ) {
		
		if(l==r) {
			System.out.println(string);
			return ;
		}
		for(int i=l;i<=r;i++) {
			if(l==i || string.charAt(i)!=string.charAt(l)) {
				 string=swap(string,i,l);
				 permuteDistinct(string,l+1,r);
				 string=swap(string,i,l);
			}
		}

	}
	
	private static void permute(String string, int l, int r ) {
		
		if(l==r) {
			System.out.println(string);
			return ;
		}
		for(int i=l;i<=r;i++) {
				 string=swap(string,i,l);
				 permuteDistinct(string,l+1,r);
				 string=swap(string,i,l);
		}

	}

	private static String swap(String string, int i, int l) {
		char[] charA=string.toCharArray();
		//System.out.println(string);
		char temp=charA[i];
		charA[i]=charA[l];
		charA[l]=temp;
		return String.valueOf(charA);
	}

}
