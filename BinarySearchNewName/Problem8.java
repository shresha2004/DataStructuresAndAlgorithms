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

    
    public int searchOptimal(int[] nums, int target) {
        int n = nums.length;
       int low = 0;
       int high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(target == nums[mid]) return mid;
            else if(nums[low] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[low]){
                    high = mid-1;
                }else low = mid+1;
            }
            else {
                if(target >= nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            };
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
      System.out.println("Optimal:"+s.searchOptimal(nums, target));
    }
    
}
