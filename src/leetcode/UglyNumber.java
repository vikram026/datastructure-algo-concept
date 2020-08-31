package leetcode;

public class UglyNumber {
  public static void main(String[] args) {
    System.out.println("******************Find the nth ugly number ********************** ");
    UglyNumber uglyNumber = new UglyNumber();
    int n = 1690;
    int result = uglyNumber.getUglyNumber(n);
    System.out.println("the" + n + "th ugly number is" + result);


  }

  private int getUglyNumber(int n) {
    int ugly[] = new int[n];
    int i2 = 0, i3 = 0, i5 = 0;
    int next_multipleOf2 = 2;
    int next_multipleOf3 = 3;
    int next_multipleOf5 = 5;
    int nextUglyNo = 1;
    ugly[0] = 1;
    for (int i = 1; i < n; i++) {
      nextUglyNo = Math.min(Math.min(next_multipleOf2, next_multipleOf3), next_multipleOf5);
      ugly[i] = nextUglyNo;
      if (next_multipleOf2 == nextUglyNo) {
        i2=i2+1;
        next_multipleOf2 = ugly[i2] * 2;
      }
      if (next_multipleOf3 == nextUglyNo) {
        i3=i3+1;
        next_multipleOf3 = ugly[i3] * 3;
      } if(next_multipleOf5 == nextUglyNo) {
        i5++;
        next_multipleOf5 = ugly[i5] * 5;
      }
    }
    for (int i = 0; i < n; i++) {
      System.out.println(ugly[i] + " ");
    }
    return nextUglyNo;
  }

}
