package string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrangeWordsInString {

    public static void main(String[] args) {
        String s="india is good";
        StringBuilder sb=new StringBuilder(s);
        sb.setCharAt(0,(char)(s.charAt(0)+32));
        String[] splited=s.split(" ");


        class comp implements Comparator<String> {
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        }
        //Arrays.sort(splited,new comp());
        String str= Stream.of(sb.toString().split(" ")).sorted(new comp() ).collect(Collectors.joining(" "));
        StringBuilder sbr=new StringBuilder(str);
        sb.setCharAt(0,(char)(s.charAt(0)-32));
       // return sb.toString();
        System.out.println(sb.toString());
    }
}
