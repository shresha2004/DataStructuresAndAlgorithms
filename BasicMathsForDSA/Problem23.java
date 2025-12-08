//Problem:https://leetcode.com/problems/smallest-range-i/description/
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int ele : nums){
            min = Math.min(min,ele);
            max = Math.max(max,ele);
        }
        return Math.max(0,(max-k)-(min+k));
    }
}
public class Problem23 {
    public static void main(String[] args) {
        int[]  nums = {1,3,6};
        int k = 3;
        Solution s = new Solution();
        System.out.println("Solution:"+s.smallestRangeI(nums, k));
    }
}
