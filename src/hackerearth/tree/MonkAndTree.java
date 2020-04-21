package hackerearth.tree;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.io.BufferedReader;
import java.io.InputStreamReader;
class TestClass {
    
    static class Node {
	int data;
	Node left,right;
	public Node(int data){
		this.data=data;
		left=right=null;
	}
    }
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] s=br.readLine().split(" ");
            int n=Integer.parseInt(s[0]);
            int n2=Integer.parseInt(s[1]);
            
            String[] s2=br.readLine().split(" ");
            Node root=null;
            for(int i=0;i<n;i++){
                root=insert(root,Integer.parseInt(s2[i]));
            }
            int i=n;
            while(i<s2.length){
                if(isAvailable(root,Integer.parseInt(s2[i])))
                    System.out.println("YES");
                else{
                    System.out.println("NO");
                    root=insert(root,Integer.parseInt(s2[i]));
                }
                i++;
            }
              

        }
    }
    public static Node insert(Node root,int data){
		if(root==null) {
			root=new Node(data);
			return root;
		}
		if(root.data>=data) {
			root.left=insert(root.left,data);
		}
		else {
			root.right=insert(root.right,data);
		}
		return root;
		
	}
	public static boolean isAvailable(Node root,int key){
	    if(root==null)
	        return false;
	    if(root.data==key)
	       return true;
	    else if(root.data>key)
	        return isAvailable(root.left,key);
	    else 
	       return isAvailable(root.right,key);

	}
}

/*
 * 
 5 6
1 5 2 1 2 3 3 5 2 1 5
*/


