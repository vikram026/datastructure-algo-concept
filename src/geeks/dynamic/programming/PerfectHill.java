package geeks.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
//perfect hill=Max_Inc_Sequencece + Max_Dec_Sequencece;
//for max increasing sequence take a num and compare with it's previous no if seq is there then save its sequence in array Max_Inc_Sequencece_Array and  same for decreasing sequence

public class PerfectHill {
	private static int N=8;
	static int[] Max_Inc_Sequencece_Array;
	static int[] Max_Dec_Sequencece_Array;
	static int[] Max_Inc_Sequencece_Array_predecessor;
	static int[] Max_Dec_Sequencece_Array_predecessor;
	
	private static void setIncreasing_DecreasingArray(int[] a, int n) {
		Max_Inc_Sequencece_Array=new int[n];
		Max_Dec_Sequencece_Array=new int[n];
		Max_Inc_Sequencece_Array_predecessor=new int[n];
		Max_Dec_Sequencece_Array_predecessor=new int[n];
		for(int i=0,k=n-1;i<n&&k>=0;i++,k--) {
			//Max_Inc_Sequencece_Array[i]=Max_Dec_Sequencece_Array[i]=1;  //chances of defect;
			int max_inc_length=1,max_dec_len=1;
			int predecessor_Inc_Sequence=-1,predecessor_dec_Sequence=-1;
			for(int j=i-1,l=k+1;j>=0&&l<n;j--,l++) {
				if(a[i]>a[j]) {
					if(max_inc_length<(1+Max_Inc_Sequencece_Array[j])) {
						max_inc_length=1+Max_Inc_Sequencece_Array[j];
						predecessor_Inc_Sequence=j;
					}
				}
				if(a[k]>a[l]) {
					if(max_dec_len<(1+Max_Dec_Sequencece_Array[l])) {
						max_dec_len=1+Max_Dec_Sequencece_Array[l];
						predecessor_dec_Sequence=l;
					}
				}
			}
			Max_Inc_Sequencece_Array[i]=max_inc_length;
			Max_Dec_Sequencece_Array[k]=max_dec_len;
			Max_Inc_Sequencece_Array_predecessor[i]=predecessor_Inc_Sequence;
			Max_Dec_Sequencece_Array_predecessor[k]=predecessor_dec_Sequence;
		}
	}

	private static void printDec(int peek_Index, int[] a, int div_Peek) {
		while(div_Peek-->0) {
			System.out.print(a[peek_Index]+" ");
			peek_Index=Max_Dec_Sequencece_Array_predecessor[peek_Index];
		}
		
	}
	private static void printInc(int peek_Index,int[] a,int iterater) {
		if(iterater==0 ||peek_Index==-1)
			return;
		printInc(Max_Inc_Sequencece_Array_predecessor[peek_Index],a,iterater--);
		System.out.print(a[peek_Index]+" ");
	}
	public static void main(String[] args){
		int [] a= {10,15,16,9,4,3,11,1};
		System.out.println("10,15,16,9,4,3,11,1");
		setIncreasing_DecreasingArray(a,a.length);
		//setDecreasingList(a,a.length);
		int[] maxHill=new int[a.length];
		int max_length=-1;
		int peek_Index=-1;
		System.out.println("Max_Inc_Sequencece_Array[i] + Max_Dec_Sequencece_Array[i] + Max_Inc_Sequencece_Array_predecessor[i] + Max_Dec_Sequencece_Array_predecessor[i] + maxHill[i]");

		for(int i=0;i<N;i++) {
			maxHill[i]=Math.min(Max_Inc_Sequencece_Array[i],Max_Dec_Sequencece_Array[i])*2-1;
			System.out.println(Max_Inc_Sequencece_Array[i]+" "+Max_Dec_Sequencece_Array[i]+" " +Max_Inc_Sequencece_Array_predecessor[i]+" "+Max_Dec_Sequencece_Array_predecessor[i]+" " +maxHill[i]);
			if(maxHill[i]>max_length){
				max_length=maxHill[i];
				peek_Index=i;
			}
		}
		int div_Peek=maxHill[peek_Index]/2;
		System.out.println("PERFECT HILL VALUES ARE:");
		printInc(Max_Inc_Sequencece_Array_predecessor[peek_Index],a,div_Peek);
		printDec(peek_Index,a,maxHill[peek_Index]-div_Peek);	
	}
}



