package linkedlist;


public class Rotate {
    
     /*  This function should rotate list counter-
    clockwise by k and return new head (if changed) */
    public Node rotate(Node head, int k) {
        int n=1;
        if(head==null)
        return null;
        Node temp=head;//end=head;
        while(temp.next!=null){
            n++;
            //end=temp;
            temp=temp.next;
            
            
        }
        Node temp1=head;
        int c=1;
        while(c++<k%n){
            temp1=temp1.next;
        }
        if(k%n!=0){
	        temp.next=head;
	        head=temp1.next;
	        temp1.next=null;
        }
        return head;
        }
        
}
