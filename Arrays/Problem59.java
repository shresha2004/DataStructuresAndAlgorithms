//Problem:https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=binary-search
class Solution {
    public int minSubArrayLenBruteForce(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        if(n==1 && nums[0]==target) return 1;
        if(n==1 && nums[0]!= target) return 0;

        for(int i =0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                if(sum>= target) minLen = Math.min(j-i+1,minLen);
            }
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
        
    }

    public int minSubArrayLenOptimal(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
       int sum = 0;
       while(high < n){
         sum += nums[high++];
        while(sum>=target){
            minLen = Math.min(minLen,high-low);
            sum-=nums[low++];
        }
        
       }
      
       
       return minLen==Integer.MAX_VALUE ? 0 : minLen ;
        
    }
}
public class Problem59 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println("Brute Force:"+s.minSubArrayLenBruteForce(target, nums));
        System.out.println("Optimal:"+s.minSubArrayLenOptimal(target, nums));
    }
}
