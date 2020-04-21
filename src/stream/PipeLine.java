package stream;

import java.util.Arrays;

public class PipeLine  {
	public static void main(String[] args) {
		long count=Arrays.asList(1,2,3,4).stream().peek(System.out::println).filter(e->e%2==0)
		.peek(System.out::println).map(e->e*10).peek(System.out::println).count();
		System.out.println("\n"+count);
		 Interface1 i=()->{
			 Interface1 j=()->3;
			 
			 return 2;
		 };
		   
	}

  

}
