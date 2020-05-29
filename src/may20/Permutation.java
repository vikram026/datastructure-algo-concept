package may20;

public class Permutation {
    public static void main(String[] args) {
        char[] a="aac".toCharArray();
        printAll(a,0,2);
    }
    private static void printAll(char[] a,int l,int r){
        if(l==r){
            System.out.println(String.valueOf(a));
        }

        for(int i=l;i<=r;i++){
            if(l==i || a[l]!=a[i]) {
                swap(a, i, l);
                printAll(a, l + 1, r);
                swap(a, i, l);
            }
        }
    }

    private static void swap(char[] a, int i, int l) {
        char temp=a[i];
        a[i]=a[l];
        a[l]=temp;
    }

}
