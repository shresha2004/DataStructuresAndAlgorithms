//Problem:https://leetcode.com/problems/4sum-ii/description/?envType=problem-list-v2&envId=hash-table
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    for(int l=0;l<n;l++) if(nums1[i]+nums2[j]+nums3[k]+nums4[l]==0) count++;
                }
            }
        }
      return count;  
    }
}
public class Problem10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = { 1, 2 };
        int[] nums2 = { -2, -1 };
        int[] nums3 = { -1, 2 };
        int[] nums4 = { 0, 2 };

        System.out.println("Brute Force:"+s.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
