package corejava.exception;

public class MethodOverloading {
    public static void main(String[] args) {
        sum( 2f,3);
        String s="numa";
        s.contains('a'+"");
        s.indexOf('a');
    }

    private static void sum(int i, float i1) {

    }
    private static void sum(float i, int i1) {

    }
}
