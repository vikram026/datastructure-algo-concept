package string;

import java.util.Arrays;

public class RemoveDuplicate {
	static char[] sample= {'a','v','s','a','v','g','b','n','g','n','h','a','v','f','g','d','b','t','r','a'};
	//static char[] sample= {'a','a'};
	public static void main(String[] args) {
		int breakPoint=removeDuplicate(sample);
		for(int i=0;i<=breakPoint;i++) {
			System.out.print(sample[i]+" ");
		}
	}
	private static int removeDuplicate(char[] sample) {
		int[] hashTable=new int[256];
		Arrays.fill(hashTable,0);
		int i=0,j=0;
		while(j<sample.length) {
			if(hashTable[sample[i]]==0) {
				
				hashTable[sample[i]]=1;
				i++;j++;
				
			}
			else {
				while(j<sample.length && hashTable[sample[j]]==1  )j++;
				if(j<sample.length) {
					 swap(sample,i,j);	
					 hashTable[sample[i]]=1;
					 i++;j++;
				 }
				 
			}
			
		}
		return i-1;
	}
	private static void swap(char[] sample, int i, int j) {
		int temp=sample[i];
		sample[i]=sample[j];
		sample[j]=(char) temp;
	}
}
