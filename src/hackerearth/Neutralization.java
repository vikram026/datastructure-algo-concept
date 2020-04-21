package hackerearth;


import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Neutralization {
    public static void main(String args[] ) throws Exception {
   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim()); 
		String s=br.readLine().trim();
		 String response=  merge(s);
		while(!response.equals(s)){
		    s=response;
		    response=merge(s);
		  
		}
		System.out.println(response.length());
		System.out.println(response);
	
		
    

    }
    private static String merge(String s){
        String temp="";     
        for(int i=0;i<s.length()-1;){

             if(s.charAt(i)==s.charAt(i+1)){
                    i+=2;
                    if(i==s.length()-1) {
                    	temp+=s.charAt(i)+"";
                    }
                   
             }
             else{ 
            	 if(i==s.length()-2)
                     temp+=s.charAt(i)+""+s.charAt(i+1);
             	else
             		 temp+=s.charAt(i)+"";
            	 i++;
                 }
        }
        
        return temp;
    }
}