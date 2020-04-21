package arrays;
//find the maximum difference where Larger element is in right side 
public class MaxDifferenceRightElementAlwaysGreater {
	public static void main(String[] args) {
		maxDifferenceRightElementAlwaysGreaterApproach1();
		maxDifferenceRightElementAlwaysGreaterApproach2();
		
	
	}

	

	private static void maxDifferenceRightElementAlwaysGreaterApproach1() {
		int[] a= {3,2,4,1,10,7,8,12};
		int minimumSoFar=a[0];
		int maxDiff=0;
		for(int i=1;i<a.length;i++) {
			if(minimumSoFar>a[i]) {
				minimumSoFar=a[i];
			}
			else {
				maxDiff=Math.max(maxDiff, a[i]-minimumSoFar);
			}
			
		}
		System.out.println("MaxDifference ::: "+maxDiff);
		
	}
	private static void maxDifferenceRightElementAlwaysGreaterApproach2() {
		int[] a= {3,2,4,1,10,7,8,12};
		int[] diff=new int[a.length-1];
		for(int i=0;i<a.length-1;i++) {
			diff[i]=a[i+1]-a[i];
		}
		for(int i=0;i<a.length-1;i++) {
			System.out.print(diff[i]+" ");
		}
		
		//find max sum sub array;
		int maxSum=diff[0],sum=diff[0];
		for(int i=1;i<diff.length;i++) {
			if(sum+diff[i]>0) {
				sum+=diff[i];
				maxSum=Math.max(maxSum, sum);
			}
			else		
				sum=0;
		}	
		System.out.println("Max Difference is : "+maxSum);
		
	}

}
