package matrix;
class Celebrity
{
    // The task is to complete this function
    int getId(int M[][], int n)
    {
        
        
       // int celeb=0;
        
        boolean flag=true;
        for(int i=1;i<n;i++){
            if(M[0][i]==1){
                flag=false;
                if(checkCelebrity(M,i,n)){
                    return i;
                }
            }
        }
        if(flag){
            for(int i=1;i<n;i++){
                if(M[i][0]==0)
                    return -1;
            }
        }
       
        return flag==true?0:-1;
    }
    private boolean checkCelebrity(int[][] M,int j,int n){
        for(int i=0;i<n;i++){
            if(M[j][i]==1)
                return false;
        }
        return true;
    }
}