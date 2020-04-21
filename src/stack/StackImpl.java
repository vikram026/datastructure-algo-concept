package stack;

import java.util.Scanner;
import java.util.Stack;

public class StackImpl
 {
	public static void main (String[] args)
	 {Scanner sc=new Scanner(System.in);
	  int t=sc.nextInt();
	  while(t-->0){
	      int flag=0;
	      Stack<Character> stack=new Stack<>();
	      String str=sc.next();
	      char[] charArray=str.toCharArray();
	      int n=str.length();
	      if(n%2!=0){
	       System.out.println("not balanced");
	       continue;
	      }
	      for(int i=0;i<n;i++){
	          if(charArray[i]=='{' || charArray[i]=='('|| charArray[i]=='[')
	            stack.push(charArray[i]);
	          if(! stack.empty() && ( charArray[i]=='}' || charArray[i]==')'|| charArray[i]==']')){
	              char temp=stack.peek();
	              if(!stack.empty() && ((charArray[i]=='}' && temp=='{') || (charArray[i]==')' && temp=='(') || (charArray[i]==']' && temp=='['))) 
	                  stack.pop(); 
	              else{
	                flag=1;break;
	              }
	          }
	         // System.out.println(stack.peek());
	              
	      }
	      if(!stack.empty() && flag==1 )
	          System.out.println("not balanced");
	      else
	          System.out.println("balanced");
	    } 
	 }
}
