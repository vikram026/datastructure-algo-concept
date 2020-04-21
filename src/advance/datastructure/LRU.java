package advance.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LRU {
	static Map<Integer,Node> map=new HashMap<>();
	static Node front=null, rear=null;

	static class Node {
		int data;
		Node pre, next;
		public Node(int k) {
			this.data=k;
			this.next=null;this.pre=null;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 4, 3, 1, 5, 2, 3 };
		int space = 3;
		for (int i = 0; i < a.length; i++) 
			addLRUToDLL(a[i],space);
	}

	private static void addLRUToDLL(int k,int space) {
		Node temp=new Node(k);
		if(front==null) {
			front=temp;
			rear=temp;
			map.put(k,temp);
			
		}
		else{
			if(!map.containsKey(k)){
				if(map.size()==space) {
					map.remove(rear.data);
					rear.pre.next=null;
					Node tempR=rear.pre;
					rear.pre=null;
					rear=tempR;
				}
				front.pre=temp;
				temp.next=front;
				front=temp;
				map.put(k,temp);
				
			}
			else{
				Node given=map.get(k);
				if(given.data!=front.data) {
					if(given.data==rear.data && front!=rear) {
						rear=rear.pre;
					}
					given.pre.next=given.next;
					if(given.next!=null)
					given.next.pre=given.pre;
					given.pre=null;
					given.next=front;
					front.pre=given;
					front=given;
				}
			}
		
		}
		printMap();
		
	}

	private static void printMap() {
		map.keySet().stream().forEach(e->{
			System.out.print(e+" ");
		});
		System.out.println();
		
//		Node iter=front;
//		do {
//			if(iter!=null) {
//			System.out.print(iter.data+" ");
//			iter=iter.next;}
//		}while(iter!=rear);
//		System.out.println();
		
	}

}
