package arrays;

import java.util.Stack;

//find the span for each stock in the array;
public class StockSpan {
	public static void main(String[] args) {
		int[] stockPrice= {100,80,60,70,60,75,85};
		int n=stockPrice.length;
		int[] span=new int[n];
		getSpan(stockPrice,span,n);
		for(int e:span)
			System.out.print(e+" ");
	}

	private static void getSpan(int[] stockPrice, int[] span, int n) {
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<n;i++) {
			while(!stack.isEmpty() && stockPrice[stack.peek()]<stockPrice[i])
				stack.pop();
			span[i]= stack.empty() ? i+1:  i-stack.peek();
			stack.push(i);
			
		}
		
		stack=null;
	}

}
