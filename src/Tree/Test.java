package Tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		String a="b";
		String b="abc";
		int bool=a.compareTo(b);
		System.out.println(bool+" ");
		
		Set<String> set=new HashSet<>();
		set.add(a);
		set.add(b);
		set.add(a);
		
		//Collections.sort(set,set.size());
		List<String> list=set.stream().distinct().sorted().collect(Collectors.toList());
		Collections.sort(list);
		for(String s:list) {
			System.out.println("value is "+s);
		}
		
		Set<String> treeSet=new TreeSet<>();
	
		Map<String,Object> map=new HashMap<>();
		//map.entrySet().stream().collect(Collectors.toMap
		
		
	
	}
	

}
