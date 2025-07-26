
//Problem:https://leetcode.com/problems/sliding-window-maximum/
import java.util.*;
class Solution {
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n-k+1;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<k;j++){
                max = Math.max(max,nums[j+i]);
            }
            ans.add(max);
        }
        int[] ansArr = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ansArr[i]=ans.get(i);
        }
        return ansArr;
        
    }
}
public class Problem23 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7}; 
        int k = 3;
        System.out.println("Brute Force:"+Arrays.toString(s.maxSlidingWindowBruteForce(nums, k)));
    }
}
