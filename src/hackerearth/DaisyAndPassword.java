package hackerearth;

import java.util.Scanner;

public class DaisyAndPassword {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n-->0) {
			String data=sc.next();
			String password=sc.next();
			hackPassword(data,password);
		}
	}

	private static void hackPassword(String data, String password) {
		String dataCopy=data;
		String formedPassword;
		for(int i=0;i<data.length(); i++) {
		formedPassword=	data.substring(0, i)+dataCopy+data.substring(i, data.length());
		//System.out.println("Formed password"+formedPassword +":data.substring(0, i) "+data.substring(0, i));
		if(formedPassword.equals(password)) {
			System.out.println("Possible");
			return ;
		}
			
		}
		System.out.println("Impossible");
	}

}
