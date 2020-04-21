package valuelab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class CompleteBinaryTree {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim());
		int q=Integer.parseInt(br.readLine().trim());
		int[] a=new int[n+1];
		int[] qA=new int[q];
		for(int i=1;i<=n;i++) {
			a[i]=i;
		}
		while(q-->0) {
			int query=Integer.parseInt(br.readLine().trim());
			int count=0;

			Queue<Integer> queue=new LinkedList<>();
			queue.add(query);
			while(!queue.isEmpty()){
				int temp=queue.poll();
				if(a[temp]%2==0)
					count++;
				if((temp*2)<=n)
				 queue.add(temp*2);
				if((temp*2+1)<=n)
					queue.add(temp*2+1);
			}
			System.out.println("Even Count for query ->"+query +" is = "+count);
		}		
	}

}
