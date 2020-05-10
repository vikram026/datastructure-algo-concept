package stack;

import java.util.Stack;

public class ValidParanthesis {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}
    public static boolean isValid(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        if(n==0)
            return true;
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(curr=='(' || curr=='{' || curr=='[')
                stack.push(curr);
            else if(!stack.isEmpty() && stack.peek()==curr)
                stack.pop();
            else
                return false;
                
        }
        
        return stack.isEmpty() ? true:false;
    }
}