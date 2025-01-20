package BinarySearch;
//Problem:https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int searchBruteForce(int[] nums, int target) {
        int n = nums.length;
        
        for(int i =0 ; i<n; i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int[]  nums = {4,5,6,7,0,1,2};
      int target = 0;
      System.out.println("My Brute Force:"+s.searchBruteForce(nums, target));
    }
    
}
