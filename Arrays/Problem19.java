//Problem:https://www.naukri.com/code360/problems/maximum-subarray-sum_630526?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM
 class Solution {
	
	public  long maxSubarraySumBruteForce(int[] arr, int n) {
		// write your code here
		int maxSum=Integer.MIN_VALUE;
       
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                maxSum=Math.max(maxSum,sum);
            }
            
        }
		if(maxSum>0)
		return maxSum;
		return 0;
	}

    public  long maxSubarraySumOptimal(int[] arr, int n) {
	
		long maxSum=Long.MIN_VALUE;
		long sum=0;
       
        for(int i=0;i<n;i++){
			sum+=arr[i];
			if(sum>maxSum){
				maxSum=sum;
			}
            if(sum<0) sum=0;
        }
		if(maxSum>0)
		return maxSum;
		return 0;
	}

}

public class Problem19 {
     public static void main(String[] args) {
        int[] digits = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        int n=digits.length;
        Solution s= new Solution();
        System.out.println("BruteForce:"+s.maxSubarraySumBruteForce(digits,n));
       System.out.println("Optimal:"+s.maxSubarraySumOptimal(digits,n));
    }
    
}
