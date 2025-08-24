//Problem:https://leetcode.com/problems/target-sum/description/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return countWays(nums,target,n,0,0);
    }
    private int countWays(int[] nums,int target,int n,int checkTarget,int index){
        if(index == nums.length){
            if(checkTarget==target) return 1;
            else return 0;

        }
        int pick1 = countWays(nums,target,n,checkTarget+nums[index],index+1);
        int pick2 = countWays(nums,target,n,checkTarget-nums[index],index+1);
        return pick1+pick2;
    }

}
public class Problem21 {
    public static void main(String[] args) {
        Solution s = new  Solution();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println("Recursion:"+s.findTargetSumWays(nums, target));
    }
}
