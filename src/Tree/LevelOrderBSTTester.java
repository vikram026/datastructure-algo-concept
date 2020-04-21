package Tree;
import java.util.LinkedList;
import java.util.Queue;
class NodeDetails{
	int data;
	int min,max;
	public NodeDetails(int data,int min,int max) {
		this.data=data;	this.min=min;	this.max=max;
	}
}

//tough
public class LevelOrderBSTTester {
	
	public static boolean checkLevelOrder(int[] a,int n) {
		if(n==0)
			return true;
		Queue<NodeDetails> q=new LinkedList<>();
		int i=0;
		q.add(new NodeDetails(a[i++],-1,303030));
		while(i!=n && !q.isEmpty()) {
			NodeDetails temp=q.poll();
			if(i<n && a[i]<temp.data && a[i]>temp.min) {
				q.add(new NodeDetails(a[i++],temp.min,temp.data));
			}
			if(i<n && a[i]>temp.data && a[i]<temp.max) {
				q.add(new NodeDetails(a[i++],temp.data ,temp.max));
			}
		}
		if(i==n)
			return true;
		return false;
	}
	public static void main(String[] args) {
		int[] a={7, 4, 12, 3, 6, 8, 1, 5, 10,13};
		boolean b=checkLevelOrder(a,10);
		System.out.println(b);
	}
}
