package linkedlist;

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
//		//head=insert(head,6);
//		
//	
//		//head.next.next.next.next.next.next=head.next.next.next;
//		int k=4;
//		head=makeLoop(head,k);
//		boolean b=detectCycle(head);
//		System.out.println("Is there cycle?"+b);
//		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Remove Node ");
////		int k=4;
////		head=makeLoop(head,k);
//		Node node=removeTheLoop(head);
//		 b=detectCycle(head);
//		 System.out.println("Is there cycle?"+b);
		
		
		ReverseOrder rev=new ReverseOrder();
		rev.reorderlist(head);
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
		 
		
		
		
		
		
	}
	private static void print(Node head) {
		if(head==null)return;
		System.out.print(head.next+" ");
		print(head.next);
	}
private static Node makeLoop(Node head, int k) {
	Node temp=head,temp2=head;
		while(temp.next!=null)
			temp=temp.next;
		int c=1;
		while(c++<k)temp2=temp2.next;
		temp.next=temp2;
			
		return head;
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
	  public static Node removeTheLoop(Node head){
		  Node slow=head;
		  Node fast=head;
		boolean isCycle=false;
		while(slow!=null && fast!=null && fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				isCycle=true;
				break;
			}		
		}
		if(isCycle) {
			slow=head;
			while(slow.next!=fast.next) {
				System.out.println("infastbefore");
				fast=fast.next;slow=slow.next;
			}
			if(slow.next==fast.next) {
				System.out.println("infastnull");
				 fast.next=null;
			}
		}
		return head;
	}

	

}
