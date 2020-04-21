package stream;

public class String3dotsCheck {
	public static void main(String[] args) {
		
		Interface1 it=()->1;

		Interface2 it3=(String... g)->{
			System.out.println("Implementing Interface "); 
			return 1;
		};
		
		it3.method();
		it3.method("1");
		it3.method("1","4");
		
		
	}

}
