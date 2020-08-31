package heap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//time complexity O(n) space complexity O(1)
/**
 * max no of node and height h= n/(pow(2,h+1)) 
 * 
 * so complexity=  sum(h=0,1,2...log(n))=  n/(pow(2,h+1)) * O(h)    =>   O(n)
 * 
 * @author vksingh
 *
 */
public class Heap {
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Integer[] heap= { 3, 5, 1, 8, 2, 6 };
		n=heap.length;
		createMinHeap(heap,n);
		print(heap,n);
		System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Find the maximum element from min heap &&&&&&&&&&&&&&&&&&&&&&&&");
		int max=findMaxFromMinHeap(heap);
		System.out.println("Maximum element is ::: "+max);
		
		System.out.println("\n &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Deleting an arbitrary element from the heap &&&&&&&&&&&&&&&&&&&");
		int val=2;
		deleteElement(heap,val);
		print(heap,n);
		System.out.println("\n &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& K smallest element from an array &&&&&&&&&&&&&&&&&&&&");
		int k=3;
		
		Integer[] array= {2,3,1,6,4,9,10};
		
		
		printKLargestElement(array,k);
		
		System.out.println(" \n &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Find median in a stream &&&&&&&&&&&&&&&&&&&&");
		System.out.println("Enter the size followed by values ");
		int loop=sc.nextInt();
		List<Integer> minHeap=new ArrayList<>();		
		List<Integer> maxHeap=new ArrayList<>();
		
		for(int i=0;i<loop;i++) {
			printMedian(minHeap,maxHeap,sc.nextInt());
		}
		
		
		System.out.println(" &&&&&&&&&&&&&&&&&& Merge  k sorted linked list &&&&&&&&&&&&&&& ");
	}

	private static void printMedian(List<Integer> minHeap, List<Integer> maxHeap, int current) {
		if(maxHeap.isEmpty()) {
			maxHeap.add(current);
		}
		else if(maxHeap.get(0)>=current) {
			maxHeap.add(current);
			updateMaxHeap(maxHeap,maxHeap.size(),maxHeap.size()-1);
			if(maxHeap.size()-minHeap.size()>1) {
				transfer(maxHeap,minHeap);
				maxHeapify(maxHeap, maxHeap.size(),0);
				updateMinHeap(minHeap,minHeap.size(),minHeap.size()-1);
				
			}
			    
			
		}
		else {
			minHeap.add(current);
			updateMinHeap(minHeap,minHeap.size(),minHeap.size()-1);
			if(minHeap.size()-maxHeap.size()>1)
				transfer(minHeap,maxHeap);
				//Integer[] array=minHeap.stream().toArray()
				minHeapify(minHeap,minHeap.size(),0);
				updateMaxHeap(maxHeap,maxHeap.size(),maxHeap.size()-1);
			
			
		}
		int result=-1;
		int diff=maxHeap.size()-minHeap.size();
		if(diff==0)
			result=(maxHeap.get(0)+minHeap.get(0))/2;
		else if(diff>0)
			result=maxHeap.get(0);
		else
			result=minHeap.get(0);
		System.out.println(result);
		
		
	}

	private static void minHeapify(List<Integer> heap, int n, int index) {
		  int left=2*index+1;
		  int right=2*index+2;
		  int smallest=index;
		  if(left<n && heap.get(left)<heap.get(index))
			  smallest=left;
		  if(right<n && heap.get(right)<heap.get(smallest))
			  smallest=right;
		  if(smallest!=index) {
			  swap(heap,smallest,index);
			  minHeapify(heap,n,smallest);
		  }
		
	}

	private static void maxHeapify(List<Integer> heap, int n, int index) {
		 
		  int left=2*index+1;
		  int right=2*index+2;
		  int smallest=index;
		  if(left<n && heap.get(left)>heap.get(index))
			  smallest=left;
		  if(right<n && heap.get(right)>heap.get(smallest))
			  smallest=right;
		  if(smallest!=index) {
			  swap(heap,smallest,index);
			  maxHeapify(heap,n,smallest);
		  }
		
	}

	private static void updateMinHeap(List<Integer> minHeap, int size, int index) {
		int parent=(index-1)/2;
		while(parent>=0 && minHeap.get(parent)>minHeap.get(index)) {
			swap(minHeap,parent,index);
			index=parent;
			parent=(index-1)/2;
			
		}
		
	}

	private static void transfer(List<Integer> heap1, List<Integer> heap2) {
		heap2.add(heap1.get(0));
		//heap1.remove(heap1.get(0));
		heap1.set(0,heap1.get(heap1.size()-1));
		heap1.remove(heap1.size()-1);
		
		
	}

	private static void updateMaxHeap(List<Integer> maxHeap, int size, int index) {
		int parent=(index-1)/2;
		while(parent>=0 && maxHeap.get(parent)<maxHeap.get(index)) {
			swap(maxHeap,parent,index);
			index=parent;
			parent=(index-1)/2;
			
		}
		
		
	}

	private static void swap(List<Integer> heap, int parent, int index) {
		int temp=heap.get(index);
//		int temp2=heap.get(parent);
//		heap.remove(index);
		//heap.set
		heap.set(index, heap.get(parent));
		heap.set(parent,temp);
		
	}

	private static void printKLargestElement(Integer[] array, int k) {
			createMinHeap(array,k);
			for(int i=k;i<array.length;i++) {
				//print(array,k);

				if(array[i]>array[0]) {
					swap(array,i,0);
					minHeapify(array,k,0);
				}
					
			}
			//min
			print(array,k);
		
	}

	private static void deleteElement(Integer[] heap, int val) {
		int i;
		for(i=0;i<n;i++) {
			if(val==heap[i])break;
		}
		if(i<n) {
			heap[i]=heap[n-1];
			n--;
			minHeapify(heap,n,i);
		}
			
		
	}

	private static int findMaxFromMinHeap(Integer[] heap) {
		//int n=heap.length;
		int max=Integer.MIN_VALUE;
		for(int i=(n+1)/2;i<n;i++) {
			if(heap[i]>max)
				max=heap[i];
			
		}
		return max;
	}

	private static void print(Integer[] array,int n) {
		for(int i=0;i<n;i++)
			System.out.print(array[i]+" ");
		
	}

	private static void createMinHeap(Integer[] heap,int n) {
			for(int i=n/2-1;i>=0;i--)
				minHeapify(heap,n,i);
		
	}

	private static void minHeapify(Integer[] array,int n,int index) {
	  int left=2*index+1;
	  int right=2*index+2;
	  int smallest=index;
	  if(left<n && array[left]<array[index])
		  smallest=left;
	  if(right<n && array[right]<array[smallest])
		  smallest=right;
	  if(smallest!=index) {
		  swap(array,smallest,index);
		  minHeapify(array,n,smallest);
	  }
	}

	private static void swap(Integer[] heap, int smallest, int index) {
		int temp=heap[smallest];
		heap[smallest]=heap[index];
		heap[index]=temp;
	}

}
