//Problem:https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(Math.abs(nums[j]-nums[i])==k)
                    count++;
            }
        }
        return count;
    }
}
public class Problem76 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int[]  nums = {1,2,2,1};
      int k = 1;
        System.out.println("Solution:"+s.countKDifference(nums, k));
    }
}
