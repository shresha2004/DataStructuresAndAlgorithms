//Problem:https://leetcode.com/problems/3sum-closest/description/?envType=problem-list-v2&envId=two-pointers
class Solution {
    public int threeSumClosestBruteForce(int[] nums, int target) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int curSum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(res - target) > Math.abs(target - curSum))
                        res = curSum;
                }
            }
        }
        return res;
    }
}

public class Problem66 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {-1,2,1,-4};
        System.out.println("Brute Force:"+s.threeSumClosestBruteForce(arr, 1));
       // System.out.println("Optimal:"+s.);
    }
}
