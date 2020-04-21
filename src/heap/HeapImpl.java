package heap;

public class HeapImpl {
	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 8, 2, 6 };
		int b[] = new int[20];
		int heap[] = new int[a.length];
		int n = -1;
		for (int i = 0; i < a.length; i++)
			createHeap(heap, i, a[i]);
		print(heap);
		int max = getMax(heap);
		System.out.println("1:" + max + " 2:" + getMax(heap) + "  3:" + getMax(heap) + "  4:" + getMax(heap) + "  5:"
				+ getMax(heap) + "  6:" + getMax(heap));
		print(heap);
		
		System.out.println("Deleting an arbitrary element from a min -heap");
		 

	}

	private static void print(int[] heap) {
		for (int i = 0; i < heap.length; i++)
			System.out.print(heap[i] + " ");
	}

	private static void createHeap(int[] heap, int n, int val) {
		heap[n] = val;
		int i = n;
		int parent = (i - 1) / 2;
		while (parent >= 0 && heap[parent] < heap[i]) {
			swap(heap, parent, i);

			i = parent;
			parent = (i - 1) / 2;
		}
	}

	private static void swap(int[] heap, int parent, int i) {
		int temp = heap[parent];
		heap[parent] = heap[i];
		heap[i] = temp;
	}

	private static int getMax(int[] heap) {
		int max = heap[0];
		int n = heap.length - 1;
		while (heap[n] == -1)
			n--;
		heap[0] = heap[n];
		heap[n] = -1;
		int i = 0;
		while ((i * 2 + 1) < n && heap[i * 2 + 1] != -1) {
			if (heap[i * 2 + 1] > heap[i] && heap[i * 2 + 1] > heap[i * 2 + 2]) {
				swap(heap, i * 2 + 1, i);
				i = i * 2 + 1;
			} else if (heap[i * 2 + 2] > heap[i]) {
				swap(heap, i * 2 + 2, i);
				i = i * 2 + 2;
			} else {
				break;
			}
		}
		return max;
	}
}
