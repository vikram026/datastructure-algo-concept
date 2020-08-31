package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KFrequent {
  
  public static void main(String[] args) {
//    char ch='1';
//    int a=Character.getNumericValue(ch)+Character.getNumericValue('1');;
//    System.out.println(a);
    int n=8;
    String s=String.valueOf(n);
    System.out.println(s);
    long l=Long.parseLong(s);
    System.out.println("llong: "+l);
    
  }
  public int[] topKFrequent(int[] nums, int k) {
      int n=nums.length;
      
      Map<Integer,Integer> frequencyMap=new HashMap<>();
      for(int i=0;i<n;i++){
          if(frequencyMap.containsKey(i))
              frequencyMap.put(i,frequencyMap.get(i)+1);
          else
              frequencyMap.put(i,1);
      }
      return frequencyMap
          .entrySet()
          .stream()
          .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
          .map(Map.Entry::getValue)
          .limit(k).mapToInt(x -> x).toArray();
          
      
  }
}

