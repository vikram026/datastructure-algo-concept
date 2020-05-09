package arrays;

import java.util.Stack;
//find the maximum area;
public class HistogramLargestArea {
	public static void main(String[] args) {
//		int[] hist= {5,3};
//		int max=getMaxArea(hist);
		
		int n=17;
		int x=n<<1;
		System.out.println("Maximum Area in the Histogram is ->  "+x);
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
				System.out.print(area_with_top+" ");
				max_area=Math.max(max_area, area_with_top );
			}
		}
		while(!stack.empty()) {
			top=stack.pop();
			area_with_top=hist[top]*(stack.isEmpty()?i:(i-stack.peek()-1));
			System.out.print(area_with_top+" ");

			max_area=Math.max(max_area, area_with_top );			
		}
		return max_area;
	}

}
