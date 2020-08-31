package divideandconquer;

public class FindPeakElement {
	public static void main(String[] args) {
		Solution  sol=new Solution();
		int[] a= {1,2,10};
		int peak=sol.findPeakElement(a);
		//int peak= findPeakIndex(a,0,a.length-1);
		System.out.println("peak index is"+peak);
	}
}
class Solution {
    int n;
    public int findPeakElement(int[] nums) {
        n=nums.length;
        //if(n==1) return 0;
       // if(n<3) return 0;
        return findPeakUtils(nums,0,n-1);
        
    }
    private int findPeakUtils(int[] nums,int s,int e){
        if(s<=e){
            int mid=(s+e)/2;
            if( ( mid==0 || (nums[mid-1]<=nums[mid])) && (mid==n-1 || nums[mid]>=nums[mid+1])){
               return mid;
            }
            return ( mid>0 && (nums[mid-1]>nums[mid]) ) ? findPeakUtils(nums,s,mid):findPeakUtils(nums,mid+1,e);
        }
    return -1;
    }
}