package linkedlist;


//separate the list ::
public class SegregateEvenAndOddElement {


    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode end=head,temp=head,newEnd;
        boolean isFirstOdd;
        while(end.next!=null){
            end=end.next;
        }
        newEnd=end;
        ListNode pre=null;
        while(temp!=end && temp.val%2==0){
            newEnd.next=temp;
            temp=temp.next;
            newEnd=newEnd.next;
            newEnd.next=null;


        }

        if(temp.val%2!=0){
            head=temp;
            while(temp!=end){
                if(temp.val %2!=0){
                    pre=temp;
                    temp=temp.next;
                }
                else{
                    pre.next=temp.next;
                    temp.next=null;
                    newEnd.next=temp;
                    newEnd=newEnd.next;
                    temp=pre.next;
                }
            }
        }
        else pre=temp;
        if(end!=newEnd && temp.val%2==0){
            pre.next = temp.next;
            temp.next = null;
            newEnd.next = temp;
        }
        return head;

    }
}
