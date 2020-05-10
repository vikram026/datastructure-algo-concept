package divideandconquer;

public class PowerFunction {
	public static void main(String[] args) {
		
		int n=0;
		int x=2;
		int value=calculatePower(x,n);
		System.out.println("power of x to n "+value);
	}

	private static int calculatePower(int x, int n) {
		if(n==0)return 1;
		if(n==1) return x;
		if(n%2==0)
			return calculatePower(x,n/2)*calculatePower(x, n/2);
		else 
			return calculatePower(x,n/2)*calculatePower(x,n/2)*x;
		
	}

}
