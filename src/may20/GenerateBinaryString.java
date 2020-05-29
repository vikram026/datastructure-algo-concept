//package may20;
//
//public class GenerateBinaryString {
//    public static void main(String[] args) {
//
//    }
//    private static void obtainBinary(char[] c,int l,int r,boolean[] flag){
//        if(l==r){
//            System.out.println(String.valueOf(c));
//            return;
//        }
//        if(flag[l]==true){
//            c[l]='0';
//            obtainBinary(c,l+1,r);
//            c[l]='1';
//            obtainBinary(c,l+1,r);
//
//        }else{
//            obtainBinary(c,l+1,r);
//            //obtainBinary(c,l+1,r);
//        }
//
//
//    }
//}
