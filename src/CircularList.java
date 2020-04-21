public class CircularList {
	
	static class Node{
		int value;
		Node left;
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Node head=null;
		head=push(head,4);
		System.out.println(head);
		
		head=push(head,7);
	    head=push(head,9);
	System.out.println(head.left);
		printList(head);
		
	}

	private static void printList(Node head) {
		Node temp=head;
		do {
			System.out.println(temp.value);
			temp=temp.left;
		}
		while(temp!=head);
		
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
	

}
