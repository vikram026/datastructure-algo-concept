package geeks.dynamic.programming;

public class Max_Sum_Increasing_Subsequence {
	
	private static void maxMethod(int maxIndex,int [] predecessor,int[] a) {
		if(maxIndex==-1)
			return;
		  maxMethod(predecessor[maxIndex],predecessor,a);
		  System.out.println(a[maxIndex]);
	}
	
	public static void main(String[] args) {
		int[] a= {20,3,1,15,16,2,12,13};
		int n=a.length;
		int[] sumArray=new int[n];
		int[] predecessor=new int[n];
		//Arrays.fill(predecessor,0);
		 int maxIndex=0;

		sumArray[0]=a[0];
		int globalMax=a[0];
		for(int i=1;i<n;i++) {
			int maxSum=a[i];
			
			predecessor[i]=-1;
		//	int sum=0;
			for(int j=i-1;j>=0;j--) {
				if(a[i]>a[j]) {
					int aZ=a[i]+sumArray[j];
					if(maxSum<aZ) {
						predecessor[i]=j;
						maxSum=aZ;
					}
				//	maxSum=Math.max(maxSum,a[i]+sumArray[j]);
					
				}
				
			}
			sumArray[i]=maxSum;
			if(globalMax<sumArray[i]) {
				globalMax=sumArray[i];
				maxIndex=i;
			}
		
		}
	
//		while(maxIndex!=-1) {
//			
//			
//			System.out.print(a[maxIndex]+" ");
//			maxIndex=predecessor[maxIndex];
//		
//		}
		maxMethod(maxIndex,predecessor,a);
	}



}
