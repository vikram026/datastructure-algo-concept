package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
  public static void main(String[] args) {
    Solution solution =new Solution();
    boolean res=solution.isPathCrossing("NESWW");
    System.out.println(res);
  }
  
  public boolean isPathCrossing(String path) {
      int x=0,y=0;
      Set<String> set=new HashSet<>();
      set.add(""+x+y);
      for(char c:path.toCharArray()){
          
          switch(c){
              case 'N' : y++;break;
              case 'S' : y--;break;
              case 'E' : x++;break;
              case 'W' : x--;break;
              
          }
          String s=""+x+y;
          if(!set.contains(s))
              set.add(s);
          else
              return true;
      }
      return false;
      
         
  }
}
