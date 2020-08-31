package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution23 {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap();
        // if(strs.length==0) 
        //     return result;
//         char[] chars=strs[0].toCharArray();
//         Arrays.sort(chars);
//         String t=String.valueOf(chars);
        
//         map.put(t,list.add(strs[0]);
        //result.add(list);
                
        // if(strs.length==1)
        //     return result;
        boolean found=false;
        for(int i=0;i<strs.length;i++){
            
            //found=false;
            //for(List<String> e : result){
               // if(isAnagram(e.get(0),strs[i])){
            
            String dum=map(strs[i]);
            if(map.containsKey(dum))
                map.get(dum).add(strs[i]);
            else{
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                
                map.put(dum,list)  ; 
                }
        }
        
        return map.values().stream().collect(Collectors.toList());
        //return result;
    }
      private String map(String s){
          char[] chars=s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
      }    
}
                
//     private boolean isAnagram(String s1,String s2){
//         int n1=s1.length();
//         int n2=s2.length();
//         if(n1!=n2)return false;
//         int[] hash=new int[26];
//         Arrays.fill(hash,0);
//         for(int i=0;i<n1;i++){
//             hash[s1.charAt(i)%97]++;
//             hash[s2.charAt(i)%97]--;
//         }
//         for(int i=0;i<26;i++){
//             if(hash[i]!=0)
//                 return false;
//         }
//         return true;
//     }