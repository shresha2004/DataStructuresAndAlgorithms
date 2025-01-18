package BinarySearch;
//Problem:https://leetcode.com/problems/search-insert-position/


class Solution {
    public int searchInsertBruteForce(int[] nums, int target) {
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

    public int searchInsertMyOptimal(int[] nums, int target) {
        int n=nums.length;
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(target < nums[mid]){
                high = mid-1;
                 ans = mid;
            }
            if(target > nums[mid]){
                
                low = mid+1;
            }
            if(target == nums[mid]) return mid;
        }
        return ans;
        
    }

}
public class Problem5 {
    public static void main(String[] args){
        Solution s = new Solution();
      int[]  nums = {1,3,5,6};
      int target = 5;
      System.out.println("Brute Force:"+s.searchInsertBruteForce(nums, target));
      System.out.println("My Optimal:"+s.searchInsertMyOptimal(nums, target));

    }
}
