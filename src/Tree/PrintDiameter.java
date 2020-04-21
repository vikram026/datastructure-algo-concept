package Tree;



public class PrintDiameter {
	public static void main(String[] args) {
		Node root=null;
		int[] a= {4,2,3,1,6,7,5};
		for(int i=0;i<a.length;i++) {
			root=insert(root,a[i]);
		}
		System.out.println("Print List 555555555555555555555555555555555555555555555555555555");
		print(root);
		Height height=new Height();
		int diameter=findDiameter(root,height);
		System.out.println(diameter);
	}

	private static int findDiameter(Node root, Height height) {
		if(root==null) {
			height.h=0;return 0;
		}
		Height lh=new Height();
		Height rh=new Height();
		int ld=findDiameter(root.left,lh);
		int rd=findDiameter(root.right,rh);
		height.h=Math.max(lh.h, rh.h)+1;
		return  Math.max(lh.h+rh.h+1, Math.max(ld, rd));
	}

	private static void print(Node root) {
		if(root==null)
			return;
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
		
	}

	private static Node insert(Node root, int v) {
		Node temp=new Node(v);
		if(root==null)
			return temp;
		
		if(v<root.data)
			root.left=insert(root.left,v);
		else
			root.right=insert(root.right,v);
			
		return root;	
	}

}
