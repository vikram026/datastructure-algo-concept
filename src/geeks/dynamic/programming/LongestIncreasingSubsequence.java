package geeks.dynamic.programming;

public class LongestIncreasingSubsequence {
	
	private static void maxMethod(int maxIndex,int [] predecessor,int[] a) {
		if(maxIndex==-1)
			return;
		  maxMethod(predecessor[maxIndex],predecessor,a);
		  System.out.println(a[maxIndex]);
	}

public static void main(String[] args) {
	//int[] a= {20,3,1,15,16,2,12,13};
	int[] a= {2,3,1,5,12,10,11};
	int n=a.length;
	int[] max_Inc_Sequencece_Array=new int[n];
	int[] predecessor=new int[n];
	//Arrays.fill(predecessor,0);
	int maxIndex=0;
    
	int globalMax=1;
	for(int i=0;i<n;i++) {
		int longest_increasingLength=1;
		max_Inc_Sequencece_Array[i]=1;

		
		
		predecessor[i]=-1;
	//	int sum=0;
		for(int j=i-1;j>=0;j--) {
			if(a[i]>a[j]) {
				int aZ=1+max_Inc_Sequencece_Array[j];
				if(longest_increasingLength<aZ) {
					predecessor[i]=j;
					longest_increasingLength=aZ;
				}
				//maxSum=Math.max(maxSum,1+Max_Inc_Sequencece_Array[j]);
				
			}
			
		}
		max_Inc_Sequencece_Array[i]=longest_increasingLength;
		if(globalMax<max_Inc_Sequencece_Array[i]) {
			globalMax=max_Inc_Sequencece_Array[i];
			maxIndex=i;
		}
	
	}

//	while(maxIndex!=-1) {
//		
//		
//		System.out.print(a[maxIndex]+" ");
//		maxIndex=predecessor[maxIndex];
//	
//	}
	maxMethod(maxIndex,predecessor,a);
}
}
