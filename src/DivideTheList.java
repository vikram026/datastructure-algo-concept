public class DivideTheList {
   static Node head1,head2;
	
	static class Node{
		int value;
		Node left;
	}
	public static void divide(Node head){
		Node slow=head;
		Node fast=head;
		while(fast.left!=head && fast.left.left!=head) {
			fast=fast.left.left;
			slow=slow.left;
		}
		if(fast.left.left==head) {
			fast=fast.left;
			slow=slow.left;
		}
		head1=head;
		Node temp=head1;
		head2=slow;
		fast.left=head2;
		while(temp.left!=slow) {
			temp=temp.left;
		}
		temp.left=head1;
	}
	

	private static void printList(Node head) {
		Node temp=head;
		do {
			System.out.print(temp.value+" ");
			temp=temp.left;
		}
		while(temp!=head);
		System.out.println("");
		
	}

	private static Node push(Node head, int value) {
		Node temp=new Node();
		Node iterator=head;
		temp.value=value;
		temp.left=head;
		if(head==null) {
			temp.left=temp;
			head=temp;
		}
		else {
			while(iterator.left!=head) {
				iterator=iterator.left;
			}
			iterator.left=temp;
		}
		
		return head;
	}
	
	public static void main(String args[]) {
		Node head=null;
		head=push(head,4);
		
		head=push(head,7);

	    head=push(head,9);

	    head=push(head,90);

	    head=push(head,91);

	    head=push(head,92);

	    head=push(head,93);

	    head=push(head,94);
	    
        printList(head);
        divide(head);
        printList(head1);
        printList(head2);
		
	}
}
