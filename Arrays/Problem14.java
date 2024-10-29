//Problem:https://leetcode.com/problems/search-insert-position/description/?envType=problem-list-v2&envId=array&difficulty=EASY
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int right=n-1;
        int left =0;
        while(left<=right){
            if(nums[left]==target) return left;
            if(nums[right]==target) return right;
            if(target>nums[left]) left++;
            if(target<nums[right]) right--; 
        }
        return left;
        
    }
}
public class Problem14 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums ={1,3,5,6};
        int target=5;
        System.out.println(s.searchInsert(nums, target));
    
    }
    
}
