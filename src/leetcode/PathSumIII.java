package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIII {
       public int pathSum(TreeNode root, int sum) {
          Map<Integer,Integer> map=new HashMap<>();
          int sumSoFar=0;
          map.put(0, 1);
          return pathSumUtils(root,sum,map,sumSoFar);    
      }
      private int pathSumUtils(TreeNode root,int sum,Map<Integer,Integer> map,int sumSoFar){
          if(root==null)return 0;
          sumSoFar+=root.val;
          int count=map.getOrDefault(sumSoFar-sum,0);
          map.put(sumSoFar,map.getOrDefault(sumSoFar,0)+1);
          
          count+= pathSumUtils(root.left,sum,map,sumSoFar)+ pathSumUtils(root.right,sum,map,sumSoFar);
          map.put(sumSoFar,map.get(sumSoFar)-1);
          return count;
          
      }
}



//approach One
class Solution {
  int count=0;
  public int pathSum(TreeNode root, int sum) {
      List<Integer> path=new ArrayList<>();
      int height=0;
      pathSumUtils(root,sum,height,path);
      return count;
      
      
      
  }
  private void pathSumUtils(TreeNode root,int sum,int height,List<Integer> list){
      if(root==null)return;
      if(list.size()==height)
          list.add(root.val);
      else
          list.set(height,root.val);
      int temp=0;
      for(int i=height;i>=0;i--){
          temp+=list.get(i);
          if(temp==sum)
              count++;
      }
      pathSumUtils(root.left,sum,height+1,list);
      pathSumUtils(root.right,sum,height+1,list);
  }
}

