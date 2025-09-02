//Problem:https://leetcode.com/problems/maximum-sum-circular-subarray/description/?utm_source=chatgpt.com
class Solution{
  public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0],curMax=0;
        int minSum = nums[0],curMin=0;
        int totalSum = 0;

        for(int num :nums){
            curMax = Math.max(curMax+num,num);
            maxSum = Math.max(curMax,maxSum);

            curMin = Math.min(curMin+num,num);
            minSum = Math.min(curMin,minSum);
            totalSum +=num;
        }
        if(maxSum < 0) return maxSum;
        return Math.max(maxSum,totalSum-minSum);
    }
}
public class Problem71 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1,-2,3,-2};
        System.out.println("Solution:"+s.maxSubarraySumCircular(arr));
    }
}
