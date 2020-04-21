package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrirotityQueueUses {
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
