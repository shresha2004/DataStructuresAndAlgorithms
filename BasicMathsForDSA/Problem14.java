//Problem:https://leetcode.com/problems/type-of-triangle/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
public String triangleType(int[] nums) {
        if((nums[0]+nums[1])<=nums[2] || (nums[1]+nums[2])<=nums[0] || (nums[0]+nums[2])<=nums[1]) return "none";
        if(nums[0]==nums[1] && nums[0]==nums[2] && nums[1]==nums[2]) return "equilateral";
        else if(nums[0]==nums[1] || nums[0]==nums[2] || nums[1]==nums[2]) return "isosceles";
        else if(nums[0] != nums[1] && nums[0] != nums[2] && nums[1] != nums[2]) return "scalene";
return "none";
    }
}
public class Problem14 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {3,3,3};
        System.out.println("Solution:"+s.triangleType(num));
    }
}
