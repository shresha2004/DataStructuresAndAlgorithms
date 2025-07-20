package BinarySearch;

//Problem:https://leetcode.com/problems/split-array-largest-sum/description/
class Solution {
    public int splitArrayBruteForce(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
           max = Math.max(max,nums[i]);
            sum += nums[i];
        }
        for(int maxSum =max;maxSum<=sum;maxSum++){
            if(countSum(nums,maxSum)==k) return maxSum;
        }
        return max;
    }
    public int splitArrayOptimal(int[] nums, int k) {
        int n = nums.length;
        int low= Integer.MIN_VALUE;
        int high = 0;
        for(int i =0;i<n;i++){
            low = Math.max(low,nums[i]);
            high += nums[i];
        }
        while(low <= high){
           int mid = (low+high)/2;
           int check = countSum(nums,mid);
           if(check > k) low = mid+1;
           else high = mid-1;
        }
        
        return low;
    }

    private int countSum(int[] nums,int maxSum){
        int n = nums.length;
        int partition = 1;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(sum +nums[i]<=maxSum){
               sum += nums[i];
            }
            else{
                partition ++;
                sum = nums[i];
            }
        }
        return partition;
    }


}
public class Problem27 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println("Brute Force:"+s.splitArrayBruteForce(nums, k));
        System.out.println("Optimal:"+s.splitArrayOptimal(nums, k));
    }
}
