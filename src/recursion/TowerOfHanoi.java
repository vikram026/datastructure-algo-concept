package recursion;

public class TowerOfHanoi {
	public static void main(String[] args) {
		TowerOfHanoi towerOfHanoi=new TowerOfHanoi();
		 long step=0;
		step=towerOfHanoi.toh(64,'A','B','C',step);
		System.out.print("\n No of step to move the tower to other tower."+step);
		
	}

	private long toh(int n,char A,char B,char C,long step) {
		if(n>0) {
			step=toh(n-1,A,C,B,step);
			System.out.println(A+"->"+B);
			step++;
			step=toh(n-1,C,B,A,step);
		}
		return step;
		
	}

}
