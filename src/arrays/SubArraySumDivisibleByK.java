package arrays;

public class SubArraySumDivisibleByK {
	
	/*
	 * [7,4,-10]
		K=5	
	 */
	
	
	public int subarraysDivByK(int[] A, int K) {
        int[] arr=new int[K];
        int count=0;
        arr[0]=1; //to match the value whose reminder is 0;
        int sum=0;
        for(int e:A){
            sum=(sum+e)%K;
            sum=sum<0?sum+K:sum;
           // count+=arr[sum];
            arr[sum]++;
        }
        
        //return count;
        //for
        for(int i=0;i<K;i++){
            System.out.print(arr[i]+" ");
            count+=(int)((long)arr[i]*(arr[i]-1))/2;
        }
        return count;
        
    }
	//other approach
	public int subarraysDivByK1(int[] A, int K) {
        int[] map = new int[K];
		map[0] = 1;
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum];
            map[sum]++;
        }
        return count;
    }

}
