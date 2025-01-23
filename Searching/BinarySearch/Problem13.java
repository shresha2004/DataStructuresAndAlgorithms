package BinarySearch;

//Problem:https://leetcode.com/problems/find-peak-element/description/
class Solution {
    public int findPeakElementBruteForce(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int index = 0;
        for(int i=1; i<n;i++){
            if(nums[i]> max){
                max = nums[i];
                index = i;
            }
        }
       return index; 
    }
}

public class Problem13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1,2,1,3,5,6,4};
        System.out.println("Brute Force:"+s.findPeakElementBruteForce(nums));
    }
}
