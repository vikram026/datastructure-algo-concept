package string;

public class ReverserTheWordsOftheSentence {
	static String sample="India is good for the gentle people";
	public static void main(String[] args) {
		int start=0, end=0;
		while( end<sample.length() && sample.charAt(end)!='\0') {
			
			if(sample.charAt(end)!=' ') 
				end++;
			
			else  {
				sample=reverseString(sample,start,end);
				//System.out.println(sample);
				start=++end;
				
			}
			
			
			
//			System.out.println("india");
//			start++;
		}
		//System.out.println(sample);
		sample=reverseString(sample,start,end-1);
		
		

		String reversedString =reverseString(sample,0,sample.length()-1);
		System.out.println(reversedString);
	}
	private static String reverseString(String sample, int i, int j) {
		char[] charArray=sample.toCharArray();
		while(i<j) {
			int temp=charArray[i];
			charArray[i]=charArray[j];
			charArray[j]=(char) temp;
			i++;j--;
		}
	
		return String.valueOf(charArray);
	}

}
