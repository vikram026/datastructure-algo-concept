package arrays;
//find the total amount of rain water roofs can contain given the sizes of the block;
public class WaterTrappingProblem {
	public static void main(String[] args) {
		int[] blockHeight= {1,0,2,0,1,0,3,1,0,2};
		int n=blockHeight.length;
		int[] leftMax=new int[n];
		int[] rightMax=new int[n];
		leftMax[0]=blockHeight[0];
		rightMax[n-1]=blockHeight[n-1];
		for(int i=1;i<n;i++) {
			if(leftMax[i-1]<blockHeight[i])
				leftMax[i]=blockHeight[i];
			else
				leftMax[i]=leftMax[i-1];
			if(rightMax[n-i]<blockHeight[n-i-1])
				rightMax[n-i-1]=blockHeight[n-i-1];
			else
				rightMax[n-i-1]=rightMax[n-i];
		}
		int sum=0;
		for(int i=0;i<n;i++) {
			System.out.println(leftMax[i]+" "+rightMax[i]);
		sum+=Math.min(leftMax[i], rightMax[i])-blockHeight[i];
		}
		System.out.println(" Total rain Water these blocks will store is: "+sum);
	}

}
