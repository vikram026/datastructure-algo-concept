public class ListOp
{
    static Node head;
   static class Node{
        Node(int val,Node n){
            this.value=val;
            this.left=n;
        }
        int value;
        Node left;
    }
   static void delete(){
	   head=null; 
   }
	
	public static void show(Node head){
	   while(head!=null){
	       System.out.println(head.value);
	       head=head.left;
	   }  
	}
	public static void main(String[] args) {
		head=new Node(4,new Node(5,null));
		show(head);
		//delete();
		show(head);
	}
}
