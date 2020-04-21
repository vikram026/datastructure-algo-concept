package linkedlist;
public class Add {
	public static void main(String[] args) {
		Node head1=null,head2=null;
		int[] a= {4, 5};
		int[] b= {3,4,5};
		for(int i=0;i<a.length;i++) 
			head1=addNode(head1,a[i]);
		print(head1);
		System.out.println("\n::::::::::::::::::::: 2 :::::::::::::::: 2:::::");
		for(int i=0;i<b.length;i++) 
			head2=addNode(head2,b[i]);
		print(head2);
		Node res=addTwoLists(head1,head2);
		System.out.println("\n:::::::::::::after :::adddding::::: 2 :::::::::::::::: 2:::::\n");
		print(res);

		
	}
    
    // This function will add the numbers represented by two linked lists
	
	
   private static  Node  addTwoLists(Node first, Node second) {
         first=reverse(first);
         second=reverse(second);
//         print(first);
//         print(second);
        int carry=0;
        Node temp,pre;
        Node res=new Node(-1);
        Node resHead=res;
        
        while(first!=null && second!=null){
            int tempV=first.data+second.data+carry;
            res.next=new Node((tempV)%10);
            res=res.next;
            carry=tempV/10;
            first=first.next;
            second=second.next;
        }
        while(first!=null){
            if(carry!=1){
            int tempV=first.data+carry;
            res.next=new Node((tempV)%10);
            res=res.next;
            carry=tempV/10;
            first=first.next;
            }
            else
                res.next=first;
        }
           while(second!=null){
            if(carry!=1){
            int tempV=second.data+carry;
            res.next=new Node((tempV)%10);
            res=res.next;
            carry=tempV/10;
            second=second.next;
            }
            else
                res.next=second;
        }
         if(carry!=0 && first==null && second==null) {
        	 res.next=new Node(carry);
         }
        return reverse(resHead.next);
        
    }
    private static  Node reverse(Node head){
    	
        if(head==null ||head.next==null)
            return head;
        Node l=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return l;
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