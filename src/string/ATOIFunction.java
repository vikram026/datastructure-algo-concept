package string;
public class ATOIFunction {
    public int myAtoi(String str) {
        str=str.trim();
        int n=str.length();
        if(n==0)return 0;
        long res=0;
        int sign=1;
        int i=0;
        if(str.charAt(0)=='-' || str.charAt(0)=='+'){
            if(str.charAt(0)=='-' )
                sign=-1;
            i++;
        }
        
        for(;i<n;i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                
                res=res*10+str.charAt(i)-'0';
                 // res=res*sign;
                if(res*sign<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                if(res*sign>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                
            }
            else if(res==0)
                return 0;
            else
                break;
        }
      
        return  (int)res*sign;
    }
}