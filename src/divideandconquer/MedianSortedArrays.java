package divideandconquer;


public class MedianSortedArrays {
	//using merge procedure;
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
        int m=nums1.length;
        int n=nums2.length;
        int i=0;
        while(i<m && n>0){
            if(nums1[i]>nums2[0])
                swap(nums1,nums2,i,n); 
            i++;
        }
        int tsum=m+n,medIndex=0,med2=0;
        if((tsum)%2==1){
            medIndex=tsum/2;
            if(medIndex<m)
              return  (double)(nums1[medIndex]);
            else{
                return (double)(nums2[medIndex-m]);
            }  
        }
        else{
            medIndex=(tsum-1)/2;
            med2=tsum/2;
            if(medIndex<m-1){
                return (double)(nums1[medIndex]+nums1[med2])/2;
                
            }
            else if(medIndex>m-1)
                return (double)(nums2[medIndex-m]+nums2[med2-m])/2;
            else{
                return (double)(nums1[medIndex]+nums2[0])/2;
            }
        }
        
    }
    private void swap(int[] nums1,int[] nums2,int i,int n){
        int temp=nums1[i];
        nums1[i]=nums2[0];
        nums2[0]=temp; 
        int j=0;
        while(j<n-1 && nums2[j]>nums2[j+1]){
            temp=nums2[j];
            nums2[j]=nums2[j+1];
            nums2[j+1]=temp; 
            j++;
        }
    }
}