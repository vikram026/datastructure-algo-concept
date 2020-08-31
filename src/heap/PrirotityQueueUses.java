package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrirotityQueueUses {
  
  class Solution {
    int k=0;
    public int[][] kClosest(int[][] points, int K) {
     PriorityQueue<int[]> pq=new PriorityQueue<>((p,q)->(q[0]*q[0]+q[1]*q[1])-(p[0]*p[0]+p[1]*p[1]));
        int n=points.length;
        for(int i=0;i<n;i++){ 
            if(i<K)
                pq.add(points[i]);
            else{
               int[] top= pq.peek();
               if((top[0]*top[0]+top[1]*top[1])>(points[i][0]*points[i][0]+points[i][1]*points[i][1])){
                   pq.poll();
                   pq.add(points[i]);
               }
            }
        }
        int[][] res=new int[K][2];
        while(!pq.isEmpty()) {
          int[] temp=pq.poll();
          res[k][0]=temp[0];
          res[k++][1]=temp[1];
          
        }
       return  res;
        
        
    }
}
	public static void main(String[] args) {
		int[] arr= {2,7,4,1,8,1};
		PriorityQueue<Integer> pqmin=createMinHeap(arr);

		PriorityQueue<Integer> pqmax=createMaxHeap(arr);
		pqmax.size();
		pqmax.poll();
		int lastStoneWeight=lastStoneWeight(arr);
		System.out.println("The weight of last stone left is "+lastStoneWeight);
		
	}

	private static PriorityQueue<Integer> createMinHeap(int[] arr) {
		PriorityQueue<Integer> pq=new PriorityQueue<>(); // initial size is 11 ;
		
		return pq;
	}

	private static PriorityQueue<Integer> createMaxHeap(int[] arr) {
		PriorityQueue<Integer> pq=new PriorityQueue<> ((a,b)->b-a); //creating max heap using;
		//using Comparator.reverseOrder()  or ((a,b)->b-a)
		
		for(int e:arr)
            pq.add(e);
		return pq;
		
	}
	private  static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int e:stones)
            pq.add(e);
        while(pq.size()>1){
            int p=pq.poll();
            int q=pq.poll();
            if(p!=q)
                pq.add(p-q);
        }
        return pq.size()==1?pq.peek():0;
            
        
    }

}
