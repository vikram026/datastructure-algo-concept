package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Test {
  public static void main(String[] args) {
    List<List<Integer>> res=new ArrayList<>();
    Map<Integer,List<Integer>> map=new TreeMap<>();
    List<List<Integer>> ress= map.values().stream().map(list->list.stream().sorted().collect(Collectors.toList())).collect(Collectors.toList());
    
    
  }

}
