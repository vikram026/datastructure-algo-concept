package geeks.dynamic.programming;

public class LongestdecreasingSubsequence {
	
	private static void maxMethod(int maxIndex,int [] predecessor,int[] a) {
		if(maxIndex==-1)
			return;
		System.out.println(a[maxIndex]);
		  maxMethod(predecessor[maxIndex],predecessor,a);
		  
	}

public static void main(String[] args) {
	//int[] a= {20,3,1,15,16,2,12,13};
	//int[] a= {2,3,1,5,12,10,11};
	int [] a= {10,15,16,9,4,3,11,1};
	int n=a.length;
	int[] Max_Dec_Sequencece_Array=new int[n];
	int[] predecessor=new int[n];
	//Arrays.fill(predecessor,0);
	 int maxIndex=0;
    
	int globalMax=1;
	for(int i=n-1;i>=0;i--) {
		int Longest_decreasingLength=1;
		Max_Dec_Sequencece_Array[i]=1;

		
		
		predecessor[i]=-1;
	//	int sum=0;
		for(int j=i+1;j<n;j++) {
			if(a[i]>a[j]) {
				int aZ=1+Max_Dec_Sequencece_Array[j];
				if(Longest_decreasingLength<aZ) {
					predecessor[i]=j;
					Longest_decreasingLength=aZ;
				}
				//maxSum=Math.max(maxSum,1+Max_Dec_Sequencece_Array[j]);
				
			}
			
		}
		Max_Dec_Sequencece_Array[i]=Longest_decreasingLength;
		if(globalMax<Max_Dec_Sequencece_Array[i]) {
			globalMax=Max_Dec_Sequencece_Array[i];
			maxIndex=i;
		}
	
	}

//	while(maxIndex!=-1) {	
//		System.out.print(a[maxIndex]+" ");
//		maxIndex=predecessor[maxIndex];
//	
//	}
	maxMethod(maxIndex,predecessor,a);
}
}
