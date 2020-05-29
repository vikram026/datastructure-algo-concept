package corejava.exception;

public class ExceptionLearningFinally {
	// A method that throws an corejava.exception and has finally.
	// This method will be called inside try-catch. 
	static void A() 
	{ 
		try { 
			System.out.println("inside A"); 
			throw new RuntimeException("demo"); 
		} 
		finally
		{ 
			System.out.println("A's finally"); 
		} 
	} 

	// This method also calls finally. This method 
	// will be called outside try-catch. 
	static void B() 
	{ 
		try { 
			System.out.println("inside B"); 
			return; 
		} 
		finally
		{ 
			System.out.println("B's finally"); 
		}

	} 

	public static void main(String args[]) 
	{ 
		try { 
			A(); 
		} 
		catch (Exception e) { 
			System.out.println("Exception caught"); 
		} 
		B();
		System.out.println("changing");

	} 
} 
