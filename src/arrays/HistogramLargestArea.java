package arrays;

import java.util.Stack;

public class HistogramLargestArea {
	public static void main(String[] args) {
		int[] hist= {5,6};
		int max=getMaxArea(hist);
		System.out.println("Maximum Area in the Histogram is ->  "+max);
	}

	private static int getMaxArea(int[] hist) {
		int n=hist.length;
		Stack<Integer> stack=new Stack<>();
		int i=0;
		int max_area=0,area_with_top=0,top=0;
		while(i<n) {
			if(stack.isEmpty()|| hist[stack.peek()]<=hist[i])
				stack.push(i++);
			else {
				top=stack.pop();
				area_with_top=hist[top]*(stack.isEmpty()?i:(i-stack.peek()-1));
				max_area=Math.max(max_area, area_with_top );
			}
		}
		while(!stack.empty()) {
			top=stack.pop();
			area_with_top=hist[top]*(stack.isEmpty()?i:(i-stack.peek()-1));
			max_area=Math.max(max_area, area_with_top );			
		}
		return max_area;
	}

}
