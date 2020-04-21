package linkedlist;

public class ReverseList {
	static Node head=null;
	public static void main(String[] args) {
		Node head=null;
		int[] a= {1,3,5,7,6,3};
		for(int i=0;i<a.length;i++) 
			head=addNode(head,a[i]);
		print(head);
//		System.out.println("\n"+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Reverse The List %%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//		Node reversedList=reverse(head);
//		//print(head);
//		print(reversedList);
		System.out.println("\n"+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Reverse The List  approach 2 %%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		reverseUsingRecursion(head);
	
	    print(ReverseList.head);
	
	}

private static void reverseUsingRecursion(Node curr) {
	if(curr==null)return ;
	
	if(curr.next==null) {
		ReverseList.head=curr;return;
		
	}
	reverseUsingRecursion(curr.next);
	curr.next.next=curr;
	curr.next=null;
	}

	private static Node reverse(Node head) {
		Node temp, current=head , pre=null;
		while(current!=null) {
			temp=current.next;
			current.next=pre;
			pre=current;
			current=temp;
		}
		return pre;
	}

	private static void print(Node head) {
		if(head==null)return;
		System.out.print(head.data+" ");
		print(head.next);
	}

	private static Node addNode(Node head,int data) {
		Node temp=head;
		if(head==null)
			temp= new Node(data);
		else {
			while(head.next!=null)
				head=head.next;
			head.next=new Node(data);
		}
		
		// TODO Auto-generated method stub
		return temp;
	}

}
