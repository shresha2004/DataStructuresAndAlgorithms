//Problem:https://leetcode.com/problems/count-number-of-nice-subarrays/description/
class Solution {
    public int numberOfSubarraysBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int containsOdd = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0)
                    containsOdd += 1;
                if (containsOdd == k)
                    count += 1;
            }
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int[] nums, int k) {
        if (k < 0)
            return 0;
        int n = nums.length;
        int count = 0;
        int right = 0;
        int left = 0;
        int ans = 0;
        while (right < n) {
            if (nums[right] % 2 != 0)
                count++;
            while (count > k) {
                if (nums[left] % 2 != 0)
                    count--;
                left++;
            }
            ans += (right - left) + 1;
            right++;
        }
        return ans;
    }
}

public class Problem6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;
        System.out.println("Brute Force:" + s.numberOfSubarrays(nums, k));
        // System.out.println("Optimal:"+s.);
    }
}
