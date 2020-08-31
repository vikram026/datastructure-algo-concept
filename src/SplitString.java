import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitString {
  public static void main(String[] args) throws IOException {
    Character ch=new Character('c');
    
    //String str="India is good "abc for abc" for good of good "abc for abc" for a while";
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String[] input= br.readLine().split(" ");
    boolean flag=false;
    
    for(int i=0;i<input.length;i++) {
    //  System.out.println("into for loop:"+ input[i]);
      if(input[i].charAt(0)=='"') {
        
        String temp="";
        while(i<input.length && !(input[i].charAt(input[i].length()-1)=='"')) {
          temp+=input[i]+" ";
          i++;        
        }
        temp+=input[i];
        System.out.println(temp);
      }
      else
      System.out.println(input[i]);

    }
    
  }
  



}
