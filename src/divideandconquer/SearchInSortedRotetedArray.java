package divideandconquer;
public class SearchInSortedRotetedArray {
	public static void main(String[] args) {
		int[] nums= {4,5,6,7,8,1,2,3};
		int target=8;
		int result=search(nums,target);
		System.out.println("Index of target-> "+target+" is -> "+result);
	}
	
    public static int search(int[] nums, int target) {
        int n=nums.length;
        if(n==0)return -1;
       return searchUtils(nums,target,0,n-1);
        
    }
    private static  int searchUtils(int[] nums,int target,int s,int e){

        if(s<=e){
            int mid=(s+e)/2;
            System.out.print(mid+" ");
            if(nums[mid]==target)
                return mid;
            
            //if right side is in increasing order and target falls in between them 
            //or left side is in increasing order and target doesn't falls in between 
            //go to right supart other wise go to left subpart;
            
            if( (nums[mid]<nums[e] && nums[mid]<target && target<=nums[e])
              || (nums[mid]>=nums[s] && (target<nums[s] ||  target>nums[mid]  ) ) ){
                return searchUtils(nums,target,mid+1,e);
            }
            
            return searchUtils(nums,target,s,mid-1);
                
        }
        return -1;
        
    }
}