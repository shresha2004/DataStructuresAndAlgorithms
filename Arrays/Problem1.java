//Problem:https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int l=0;
        for(int r=1; r<n;r++){
            if(nums[l]!=nums[r]){
                l++;
                nums[l]=nums[r];
            }
        }
        return l+1;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Solution s=new Solution();
      int[]   nums = {0,0,1,1,1,2,2,3,3,4};
        s.removeDuplicates(nums);
    }
    
}
