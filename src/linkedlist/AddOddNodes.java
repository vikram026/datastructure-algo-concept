package linkedlist;

import java.util.*;

import java.lang.*;
import java.io.*;



public class AddOddNodes
 {
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	public static void main (String[] args) throws IOException {
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     int t=Integer.parseInt(br.readLine());
	     Node head=null;
	     int n;
	     List<Integer> list;
	     while(t-->0){
	    	 head=null;
	         n=Integer.parseInt(br.readLine());
	         String[] a=br.readLine().trim().split(" ");
	         list=new ArrayList<>();
	         for( String i :a){
	        	 head=addNode(head,Integer.parseInt(i));
	         }
	        Node segList=seg(head);
	        print(segList);
	          
	     }
	     br.close();
	 }
	private static Node seg(Node head) {
		Node curr=head	,pre=null,end=head;
		
		while(end.next!=null)
			end=end.next;
		Node newEnd=end;
		while(curr.data%2==1 && curr!=end) {
			newEnd.next=curr;
			curr=curr.next;
			newEnd.next.next=null;
			newEnd=newEnd.next;
		}
		if(curr.data%2==0) {
			head=curr;
			while(curr!=end) {
				if(curr.data%2==0) {
					pre=curr;
					curr=curr.next;
				}
				else {
					pre.next=curr.next;
					curr.next=null;
					newEnd.next=curr;
					newEnd=curr;
					curr=pre.next;
				}
				
			}
		}
		else
			pre=curr;
		if(curr.data%2==1 && newEnd!=end) {

			pre.next=curr.next;
			curr.next=null;
			newEnd.next=curr;
		
		}
		
		return head;
	}
	private static void print(Node head) {
		if(head==null)return;
		System.out.print(head.data+" ");	
		print(head.next);
	}
	private static Node addNode(Node head, int data) {
		Node temp=head;
		if(head==null) {
			head=new Node(data);
		}
		else {
			while(temp.next!=null)
				temp=temp.next;
			temp.next=new Node(data);
		}
		return head;
	}
}
