package com.nisum.september;

public class DetectCycle {
	//static Node head=null;
	
	public static Node insert(Node node,int d) {
		Node temp=node;
		if(node==null)
			return new Node(d) ;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=new Node(d);
		return node;
	}

	public static void main(String[] args) {
		Node head=null;
		head=insert(head,1);
		head=insert(head,2);
		head=insert(head,3);
		head=insert(head,4);
		head=insert(head,5);
		head=insert(head,6);
		head.next.next.next.next.next.next=head.next.next.next;
		
		boolean b=detectCycle(head);
		System.out.println("Is there cycle?"+b);
	}
//floyd cycle finding;
	private static boolean detectCycle(Node head) {
		Node slow=head;
		Node fast=head;
		while(slow!=null && fast!=null && fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;			
		}
		return false;
	}

	

}
