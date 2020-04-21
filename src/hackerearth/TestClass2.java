package hackerearth;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class TestClass2 {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        for(int i=0;i<n;i++){
        	 String[] s = br.readLine().trim().split(" ");
             int day=Integer.parseInt(s[0]);
             
             int countDays=0,count=0;
             for(int j=1;j<=day;j++){
                 if(j%Integer.parseInt(s[1])==0)
                    count++;
                 if(j%Integer.parseInt(s[2])==0)
                    count++;
                 if(j%Integer.parseInt(s[3])==0)
                    count++;
                 if(count==1){
                     countDays++;count=0;
                 }
                    
             }
             System.out.println(countDays);
		}
    

    }
}