package graph.backtracking.re;

public class StringWithNBitRe {

	public static void main(String[] args) {
		char[] str=new char[3];
        getbitsString(str,0,3);
        
	}

	private static boolean getbitsString(char[] str,int low, int high) {
		if(low==high) {
			System.out.println(String.valueOf(str));
			return true;
		}
		for(int i= '0';i<='1';i++) {
			str[low]=(char)i;
			getbitsString(str,low+1,high);
			str[low]=(char)i;
		}
		return false;
	}

}
