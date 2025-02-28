package BinarySearch;
//Problem:https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/?envType=problem-list-v2&envId=binary-search
class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i]>0) pos++;
           if(nums[i]<0) neg++;
        }
        return Math.max(pos,neg);
        
    }
}

public class Problem33 {
    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,2,3};
        Solution s = new Solution();
        System.out.println("Brute Force:"+s.maximumCount(nums));
    }
}
