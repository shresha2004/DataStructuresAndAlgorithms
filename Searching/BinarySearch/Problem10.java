package BinarySearch;

//Problem:https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class Solution {
    public int findMinBruteForce(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        for(int i =1; i<n; i++){
            if(nums[i]< min) min = nums[i];
        }

      return min;  
    }

    //Keen observation to get optimal solution is finding sorted half and assigning its min value and moving to other half
    public int findMinOptimal(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;
            
            //Checks if left half is sorted
            if(nums[low] <= nums[mid]){
                min =Math.min(nums[low],min);
                low = mid+1;
            }
            //Checks if right half is sorted
            else if(nums[mid] <= nums[high]){
                min = Math.min(nums[mid],min);
                high=mid-1;
            }
        }
      return min;  
    }
}

public class Problem10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,4,5,1,2};

        System.out.println("My Brute Force:"+s.findMinBruteForce(nums));
        System.out.println("Optimal:"+s.findMinOptimal(nums));
    }
}
