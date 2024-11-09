
//Problem:https://leetcode.com/problems/contains-duplicate/description/?envType=problem-list-v2&envId=array&difficulty=EASY
class Solution {
    public boolean containsDuplicateBruteForce(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]) return true;
            }
        }
     return false;   
    }
}

public class Problem22 {
     public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {1,2,3,1};
      System.out.println("BruteForce:"+s.containsDuplicateBruteForce(nums));
     // System.out.println("Better:"+Arrays.toString(s.rearrangeArrayBetter(nums)));
    }
}
