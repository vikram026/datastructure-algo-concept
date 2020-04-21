package Tree;

public class ArrayRepresentationOfTree {
	static int N=10;
	static String[] ta=new String[N];
	static void setRoot(String rootData) {
		ta[0]=rootData;
	}
	static void set_left(int root,String s) {
		if(ta[root]==null)
			System.out.println("Can't insert "+s+" in left");
		else
			ta[2*root+1]=s;
	}
	static void set_Right(int root,String s) {
		if(ta[root]==null)
			System.out.println("Can't insert "+s+"in right");
		else
			ta[2*root+2]=s;
	}
	static void print() {
		for(int i=0;i<10;i++) {
			if(ta[i]!=null)
				System.out.print(ta[i]+" ");
			else
				System.out.print("_ ");
		}
	}
	

	public static void main(String[] args) {
		setRoot("A");
		set_left(0,"B");
		set_Right(1,"C");
		set_left(2,"D");
		set_Right(1,"E");
		set_left(2,"F");
		print();
	}

}
