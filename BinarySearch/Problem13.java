package BinarySearch;

//Problem:https://leetcode.com/problems/find-peak-element/description/
class Solution {
    public int findPeakElementBruteForce(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if((i==0 || nums[i]> nums[i-1]) && (i==n-1 || nums[i]> nums[i+1])) return i;
        }
      
        return -1;
    }

    public int findPeakElementOptimal(int[] nums) {
        int n = nums.length;
        int low =0;
        int high = n-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            if((mid == 0 || nums[mid]> nums[mid-1]) && (mid == n-1 || nums[mid]> nums[mid+1])) return mid;
            else if(nums[mid] < nums[mid+1]) low = mid+1;
            else high = mid -1;
        }
      
        return -1;
    }
}

public class Problem13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1,2,3,1};
        System.out.println("Brute Force:"+s.findPeakElementBruteForce(nums));
        System.out.println("Optimal:"+s.findPeakElementOptimal(nums));
    }
}
