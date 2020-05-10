package leetcode;
public class NextPermutation {
	public static void main(String[] args) {
		int[] nums={2,5,2,5};
		NextPermutation nextPermutation=new NextPermutation();
		nextPermutation.nextPermutation(nums);
	}
    public void nextPermutation(int[] nums) {
        
        int n=nums.length-1;
        int length=n;
        int pivot;
        
        for( n=n-1;n>=0;n--) {
        	if(nums[n]<nums[n+1])
               break;
        }
                
        for(int i=length;n>=0 && i>n;i++){
            if(nums[n]<nums[i]) {
                swap(nums,i,n);
                break;
            }
        }

        reverse(nums,n+1,length);
        for(int e:nums)
            System.out.print(e+" ");
        System.out.println();
        
    }
	
//	public void nextPermutation(int[] nums) {
//        int i = -1, j = -1;
//        for (i = nums.length - 2; i >= 0; i--) {
//            if (nums[i] < nums[i + 1]) break;
//        }
//        
//        for (j = nums.length - 1; i >= 0 && j > i; j--) {
//            if (nums[j] > nums[i]) {
//                swap(nums, i, j);
//                break;
//            }
//        }
//        reverse(nums, i + 1, nums.length - 1);
//	      for(int e:nums)
//	      System.out.print(e+" ");
//		  System.out.println();
//        
//    }
    
    private void swap(int[] nums, int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int[] nums,int p,int n){
        while(p<n){
            swap(nums,p++,n--);
        }
    }
}