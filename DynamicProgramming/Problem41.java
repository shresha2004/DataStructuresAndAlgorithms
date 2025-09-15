//Problem:https://leetcode.com/problems/longest-increasing-subsequence/description/
import java.util.*;
class Solution {
    public int lengthOfLISRecursive(int[] nums) {
        return findSeqRecursive(nums, 0, -1);
    }

    private int findSeqRecursive(int[] nums, int index, int prev) {
        if (index == nums.length)
            return 0;
        int len = 0 + findSeqRecursive(nums, index + 1, prev);
        if (prev == -1 || nums[index] > nums[prev]) {
            len = Math.max(len, 1 + findSeqRecursive(nums, index + 1, index));
        }
        return len;

    }

    public int lengthOfLISMemo(int[] nums) {
        int n = nums.length;
        int[][] memo = new int [n][n+1];
        for(int i=0;i<n;i++)
        Arrays.fill(memo[i],-1);
       return findSeqMemo(nums,0,-1,memo);
    }
    private int findSeqMemo(int[] nums,int index, int prev,int[][] memo){
        if(index == nums.length) return 0;
        if(memo[index][prev+1] != -1) return memo[index][prev+1];
         int len = 0+findSeqMemo(nums,index+1,prev,memo);
         if(prev == -1 || nums[index]>nums[prev]){
            len = Math.max(len,1+findSeqMemo(nums,index+1,index,memo));
         }
         return memo[index][prev+1]=len;
            
    }
}

public class Problem41 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] nums = {10,9,2,5,3,7,101,18};
       System.out.println("Recursive:"+s.lengthOfLISRecursive(nums));
       System.out.println("Memoization:"+s.lengthOfLISMemo(nums));
    }
}
