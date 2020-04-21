package hackerearth;

//public class MarkTheAnswer {
//
//}
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class MarkTheAnswer {
    public static void main(String args[] ) throws Exception {
   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
		String[] s=br.readLine().trim().split(" ");
		int n = Integer.parseInt(s[0]); 
        int aukat = Integer.parseInt(s[1]);
        String[] data=br.readLine().trim().split(" ");
        for(int i=0;i<n;i++) {
        	System.out.println(data[i]);
        }
        int count=0,skipped=0;
        for(int i=0;i<n;i++){
            if(skipped==2)
                break;
            if(Integer.parseInt(data[i])<aukat){
                skipped++;
            }
            else{
                count++;
            }
                
        }
        System.out.println(count);

    }
}
