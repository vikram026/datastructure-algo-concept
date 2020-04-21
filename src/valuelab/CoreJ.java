package valuelab;

public class CoreJ {
	public static void main(String[] args) {
		int x=method1();
		System.out.println(x);
	}

	private static int method1() {
		try {
			int d=1/0;
			return 1;
		}
		catch(Exception e) {
			return 2;
			
		}
		finally {
			return 3;
		}
		//return 0;
	}

}
