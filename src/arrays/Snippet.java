package arrays;

public class Snippet {
	public static void main(String[] args) {
		int[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
		System.out.print(input[0]+" ");
		for (int i = 1; i < input.length; i++) 		
		    if (input[i-1] != input[i])
		        System.out.print(input[i]+" ");
	}
}

