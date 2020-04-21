package com.nisum.september;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindPair {
	static int[] hashTable=new int[10];

	public static void main(String[] args) {
		int[] a= {2,3,4,5,6,4};
		int x=10;
		IntStream.of(a).forEach(e->{
			int b=x-e;
			if(isHashed(b)) {
			 System.out.println("yes");
			
			}
			else {
				hashIt(b);
			}
		});
	}

	private static void hashIt(int b) {
		hashTable[b]=b;
		
	}
	private static boolean isHashed(int b) {
		if(hashTable[b]!=b)
		 return false;
		else
			return true;
	}

}
