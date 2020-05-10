package advance.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class FirstUnique {
    Map<Integer,Integer> map;
    Queue<Integer> queue;
    

    public FirstUnique(int[] nums) {
        map=new HashMap<>();
        queue=new LinkedList<>();
        
       for(int i:nums){
           if(!map.containsKey(i)){
               queue.add(i);
               map.put(i,1);
               
           }
           else
              map.put(i,map.get(i)+1);
           
       } 
        
    }
    
    public int showFirstUnique() {
        
            while(!queue.isEmpty() && map.get(queue.peek())>1){
                queue.poll(); 
            }
       return queue.isEmpty()?-1:queue.peek();
        
    }
    
    public void add(int i) {
        if(!map.containsKey(i)){
               queue.add(i);
               map.put(i,1);
               
           }
           else
              map.put(i,map.get(i)+1);
    }

    
    
    public static void main(String[] args) {
    	  int[] nums= {2,3,5};
    	  FirstUnique obj = new FirstUnique(nums);
    	  int param_1 = obj.showFirstUnique();
    	  System.out.println(param_1);
    	  obj.add(5);
    	  System.out.println(obj.showFirstUnique());

		
	}
}