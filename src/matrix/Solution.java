package matrix;
public class Solution {
	static int[] a=new int[3+1];
	public static void main(String[] args) {
		int[][] matrix= {
				{0,1,1,1},
				{1,1,1,1},
				{0,1,1,1}
				
		};
		int m=matrix.length;
        if(m==0) return ;
        int n=matrix[0].length;
     
		System.out.println(countSquares(matrix));
		   for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	            	System.out.print(matrix[i][j]+" ");
	            }
	        	System.out.println();

	        }
	}
	
	//using pigeon hole principle;
    public static  int countSquares1(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0 && j!=0 && matrix[i][j]==1){

                        matrix[i][j]=Math.min(Math.min(matrix[i-1][j],matrix[i][j-1]),matrix[i-1][j-1])+1;
                    
                }
                a[matrix[i][j]]++;
            }
            
        }
        for(int i=0;i<4;i++){
          System.out.print(a[i]+" ");
        }
        // using pigeonhole principle.
        int i=1;
        int count=0;
        while(i<4&& a[i]!=0){
            count+=a[i]*i;
            i++;
        }
        return count;
    }
    
    
    
    public static int countSquares(int[][] matrix) {
      int res=0;
      if(matrix==null) return res; 
      int m=matrix.length;
      if(m==0)return res;
      
      int n=matrix[0].length;
      for(int i=0;i<m;i++)
          for(int j=0;j<n;j++){
              if(i!=0 &&  j!=0 && matrix[i][j]==1)
                  matrix[i][j]=Math.min(Math.min(matrix[i-1][j],matrix[i][j-1]),matrix[i-1][j-1])+1;
              res+=matrix[i][j];
              
          }
      
      return res;
  }
}