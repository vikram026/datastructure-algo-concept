package sorting;

public class SortArrayByParity {

  public static void main(String[] args) {
    int[] input = {3, 1, 2, 4}; //->2,4,3,1
    SortArrayByParity sortArrayByParity = new SortArrayByParity();
    int[] result = sortArrayByParity.sortArrayByParity(input);
    print(result);


  }

  public int[] sortArrayByParity(int[] A) {
    // i-odd, j=even
    int n = A.length;
    int i = 0, j = 0;
    while (i < n && j < n) {
      while (i < n && j < n && i == j && A[i] % 2 == 0) {
        i++;
        j++;
      }
      while (j < n && A[j] % 2 != 0) {
        j++;
      }
      if (i < n && j < n && i < j) {
        swap(A, i, j);
        i++;
        j++;
      }
    }
    return A;
  }

  private void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }


  private static void print(int[] result) {
    for (int val : result)
      System.out.print(val + " ");

  }


}
