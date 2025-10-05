//Problem:https://leetcode.com/problems/max-consecutive-ones-iii/description/
class Solution {
    public int longestOnesBruteForce(int[] nums, int k) {
       int n = nums.length;
        int maxLen =0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=i;j<n;j++){
                if(nums[j]==0) count++;
                if(count > k) break;
                
                maxLen = Math.max(j-i+1,maxLen);
            }
        }
        return maxLen;
    }
     public int longestOnesOptimal(int[] nums, int k) {
       int n = nums.length;
        int maxLen =0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        while(right <n ){
            if(nums[right]==0) zeros += 1;

            while(zeros > k){
                if(nums[left]==0){
                    zeros-=1;
                }
                left++; 
            }
            maxLen = Math.max(maxLen,(right-left)+1);
            right++;
            
        }
        return maxLen;
    }
} 
public class Problem2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Brute Force:"+s.longestOnesBruteForce(nums, k));
       System.out.println("Optimal:"+s.longestOnesOptimal(nums, k));
    }
}
