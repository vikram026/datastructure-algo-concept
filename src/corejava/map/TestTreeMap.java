package corejava.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class TestTreeMap {
    public static void main(String[] args) {
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 20);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("orange", 10);
        Map<String,Integer> integerMap=new HashMap<>();
        integerMap.put("one",1);

        TreeMap<Dog,Integer> treeMap = new TreeMap();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
        for (Map.Entry<Dog,Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
