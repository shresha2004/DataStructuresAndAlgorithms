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

    public int lengthOfLISTabu(int[] nums) {
        int n = nums.length;
        int[][] tabu = new int[n+1][n+1];
        for(int index = n-1;index>=0;index--){
            for(int prevIndex = index-1;prevIndex>=-1;prevIndex--){
                int notTake = 0+tabu[index+1][prevIndex+1];
                int take= 0;
                if(prevIndex == -1 || nums[index]>nums[prevIndex]){
                   take = 1+tabu[index+1][index+1];
                }
                tabu[index][prevIndex+1]=Math.max(take,notTake);
            }
        }
        return tabu[0][0];
    }
     public int lengthOfLISSpo(int[] nums) {
        int n = nums.length;
        int[] spo = new int[n+1];
        for(int index = n-1;index>=0;index--){
            int[] temp = new int[n+1];
            for(int prevIndex = index-1;prevIndex>=-1;prevIndex--){
                int notTake = 0+spo[prevIndex+1];
                int take= 0;
                if(prevIndex == -1 || nums[index]>nums[prevIndex]){
                   take = 1+spo[index+1];
                }
                temp[prevIndex+1]=Math.max(take,notTake);
            }
            spo=temp;
        }
        return spo[0];
    }
    
}

public class Problem41 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] nums = {10,9,2,5,3,7,101,18};
       System.out.println("Recursive:"+s.lengthOfLISRecursive(nums));
       System.out.println("Memoization:"+s.lengthOfLISMemo(nums));
       System.out.println("Tabulation:"+s.lengthOfLISTabu(nums));
       System.out.println("Space Optimization:"+s.lengthOfLISSpo(nums));
    }
}
