package arrays;
//find the majority element in the array that that has occured more than n/2 times; 
public class MooreVotingAlgo {
	public static void main(String[] args) {
		int[] a= {1,2,1,3,1,4,1};
		int voter = 0,count=0;
		for(int i=0;i<a.length;i++) {
			if(count==0) {
				voter=a[i];
			}
			if(voter==a[i]) {
				count++;
			}
			else
				count--;
			
		}
		if(isMajorityElement(voter,a)) {
			System.out.println("MazorityElement is "+voter);
		}
		else
			System.out.println("Mazority Element is not found");
	}

	private static boolean isMajorityElement(int voter,int[] a) {
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==voter)
				count++;
		}
		if(count>a.length/2)
			return true;
		return false;
	}

}
