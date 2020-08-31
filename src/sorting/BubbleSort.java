package sorting;

public class BubbleSort {
	private static void selectionSort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]) {
					swap(array, i, j);
				}
			}
		}
	}

  private static void swap(int[] array, int i, int j) {
    int temp=array[i];
    array[i]=array[j];
    array[j]=temp;
  }
	
//	private static void insertionSort(int[] array) {
//		for(int i=1;i<array.length;i++) {
//			int key=array[i];
//			int j=i-1;
//			while(j>=0 && array[j]>key) {
//				array[j+1]=array[j];
//				j=j-1;
//			}
//			array[j+1]=key;
//		}
//	}
	
	
	private static void insertionSort(int[] array) {
		int j=0;
		for(int i=1;i<array.length;i++) {
			j=i-1;
			while(j>=0&& array[j]>array[j+1]) {
			  swap(array,j,j+1);
			  j--;
			}  
		}
	}
	private static void bubbleSort(int[] array){
		for(int i=0;i<array.length-1;i++) {
			boolean test=false;
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j]>array[j+1]) {
					swap(array,j,j+1);
					test=true;
				}
			}
			if(!test)
				break;
		}
	}
	public static void main(String[] args) {
		int[] array= {10000,3,2,6,5,4,98,90,89,7898,987};
		insertionSort(array);
		//selectionSort(array);
		//bubbleSort(array);
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}

	

}
