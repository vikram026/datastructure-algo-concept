package divideandconquer;

public class ShuffleArray {
	public static void main(String[] args) {
		String[] array= { "a1","a2","a3","a4","b1","b2","b3","b4" };
		int n=array.length;
		suffleArray(array,0,n-1);
		print(array);
	}

	private static void print(String[] array) {
		for(String s:array)
			System.out.print(s+" ");
		
	}

	private static void suffleArray(String[] array, int s, int e) {
		if(e>s+1) {
			int mid=(s+e)/2;
			int temp=mid+1;
			int leftMid=(mid+s)/2;
			for(int i=leftMid+1;i<=mid;i++) {
				swap(array,i,temp++);
			}
			suffleArray(array,s,mid);
			suffleArray(array,mid+1,e);

		}
		
	}

	private static void swap(String[] array, int i, int j) {
		String temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}

}
