package linkedlist;
public class CloneTheListWithRandomPointer {
	static class Node{
		 int val;
		 Node next,random;
		 Node(int val){
			 this.val=val;
		 }
		
	}
	
	public static void main(String[] args) {
		Node head=new Node(7);
		head.next=new Node(13);
		head.next.next=new Node(11);
		head.next.next.next=new Node(10);
		head.next.next.next.next=new Node(1);
		head.random=null;
		head.next.random=head;
		head.next.next.random=head.next.next.next.next;
		head.next.next.next.random=head.next.next;
		head.next.next.next.next.random=head;
		Node head1=copyRandomList(head); //distroys the list
   
		
		
		print(head,head1);
		
		Node head2=copyList(head);
	
		
	}
	
    private static Node copyList(Node head) {
        if(head==null) return null;
        Node curr=head,temp,head2;
        while(curr!=null){
            temp=new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            curr=temp.next;
        }
        curr=head;;
        while(curr!=null){
            curr.next.random= curr.random!=null ? curr.random.next:null;
            curr=curr.next.next;
        }
        head2=head.next;
        temp=head2;
        curr=head;
        while(curr!=null && temp!=null){
            curr.next=curr.next.next;
            curr=curr.next;
            if(temp.next!=null){
                temp.next=temp.next.next;
                temp=temp.next;
            }
        } 
        return head2;
	}

	private static void print(Node head,Node head1) {
    	int valr=-1;
		while(head!=null) {
			
			if(head.random!=null)
				valr=head.random.val;
			System.out.print(head.val+" "+ valr+" ||");
			head=head.next;
		}
		System.out.println();
		valr=-1;
		while(head1!=null) {
			
			if(head1.random!=null)
				valr=head1.random.val;
			System.out.print(head1.val+" "+ valr+" ||");
			head1=head1.next;
		}
		
	}

	public static Node copyRandomList(Node head) {
    	
        if(head==null)return null;
        Node temp=head,backup,head2=null,temp2,temp2ite=null;
        while(temp!=null){
            backup=temp.next;
            temp2=new Node(temp.val);
             if(head2==null){
            	 
	                 temp.next=temp2;
	                 temp2.random=temp;
            
                 head2=temp2;
                 temp2ite=temp2;
            }
            else{
                temp2ite.next=temp2;
                temp2ite=temp2ite.next;
	
	                temp.next=temp2ite;
	                temp2ite.random=temp;
                
            }
           // System.out.print(temp2ite.val+" ");

            temp=backup;
   
        }
        temp2ite=head2;
        while(temp2ite!=null){
            
            //temp2ite.random.next= temp2ite.next!=null?temp2ite.next.random:null;
            
            if(temp2ite.random.random!=null)
            temp2ite.random=temp2ite.random.random.next;
            else
                temp2ite.random=null;
            
            temp2ite=temp2ite.next;
        }
        temp2ite=head;
        temp2=head2;
//        while(temp2ite!=null){
//        	temp.next=
//            
//            temp2ite=temp2ite.next;
//        }
        
       return head2; 
    }
}
