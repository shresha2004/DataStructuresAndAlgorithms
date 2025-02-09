//Problem:https://leetcode.com/problems/find-the-duplicate-number/description/

import java.util.HashMap;
class Solution {
    public int findDuplicateBruteForce(int[] nums) {
        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) > 1) return nums[i];
                    }

        return 0;
    }
    //Inplace marking approach
    public int findDuplicateOptimal(int[] nums) {
        int n= nums.length;
        
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i]) -1;
            if(nums[index] > 0) nums[index] = - nums[index];
            else return index+1;
        }
        return 0;
    }
}
public class Problem50 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,4,2,2};
        System.out.println("Brute Force:"+s.findDuplicateBruteForce(nums));
        System.out.println("Optimal:"+s.findDuplicateOptimal(nums));
    }
}
