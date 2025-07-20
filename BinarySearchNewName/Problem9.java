package BinarySearch;

//Problem:https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

class Solution {
    public boolean searchBruteForce(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(nums[i] == target) return true;

        }
        return false;
    }
    //For optimal solution nums[low] = nums[mid] = nums[high] is the keen observation
    public boolean searchOptimal(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
         while(low <= high){
            int mid = (low+high)/2;
            if (nums[mid] == target) return true;
             else if (nums[low] == nums[mid] && nums[mid] == nums[high]){
                low+=1;
                mid-=1;
            } 
           else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target <= nums[mid] )
                    high = mid-1;

                else low = mid + 1;
            }
            else {
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }

         }
        
        return false;
    }
}
public class Problem9 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {2,5,6,0,0,1,2};
        int  target = 0;
        System.out.println("My Brute Force:"+s.searchBruteForce(nums, target));
        System.out.println("Optimal:"+s.searchOptimal(nums, target));
    }
    
}
