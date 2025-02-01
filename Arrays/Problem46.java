//Problem:https://leetcode.com/problems/special-array-i/description/?envType=daily-question&envId=2025-02-01

import java.util.Arrays;

class Solution {
    public boolean isArraySpecialBruteForce(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        for(int i = 0; i<n-1;i++){
           for(int j = i+1;j<i+2;j++){
            if((nums[i]%2)==(nums[j]%2)) return false;
           }
        }
     return true;
    }
    public boolean isArraySpecialOptimal(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n-1;i++){
           if((nums[i]%2)==(nums[i+1]%2)) return false;
        }
     return true;
    }

    
}
public class Problem46 {
     public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {-4,-1,0,3,10};

        System.out.println("My Brute Force:"+(s.isArraySpecialBruteForce(nums)));
        System.out.println("My Optimal:"+(s.isArraySpecialOptimal(nums)));
    }
}
