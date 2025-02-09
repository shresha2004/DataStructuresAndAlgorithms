//Problem:https://leetcode.com/problems/find-the-duplicate-number/description/
class Solution {
    public int findDuplicateOptimal(int[] nums) {
        int n= nums.length;
        
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i]) -1;
            if(nums[index] > 0) nums[index] = - nums[index];
            else return index+1;
        }
        return 0;
    }
}
public class Problem50 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,4,2,2};
        System.out.println("Optimal:"+s.findDuplicateOptimal(nums));
    }
}
