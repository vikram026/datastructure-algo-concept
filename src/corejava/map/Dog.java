package corejava.map;

public class Dog implements Comparable<Dog>{
    String color;
    int size;
    Dog(String c, int s) {
        color = c;
        size = s;
    }
    public String toString(){
        return color + " dog"+size;
    }
    @Override
    public int compareTo(Dog o) {
        return  this.size - o.size;
    }
}