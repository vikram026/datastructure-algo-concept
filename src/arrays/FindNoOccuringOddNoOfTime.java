package arrays;
//find the no occurring odd no of time given that only one no. is occurred odd no of times.

//find the equilibrium of the array;
public class FindNoOccuringOddNoOfTime {
	public static void main(String[] args) {
		int[] a= {4,1,3,5,3,5,4,1};
		int oddNo=a[0];
		for(int i=1;i<a.length;i++) {
			oddNo^=a[i];
		}
		if(oddNo!=0)
		  System.out.println(oddNo);
		else {
			System.out.println("There is no any such cases");
		}
		
	}
}
