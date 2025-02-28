package BinarySearch;
//Problem:https://leetcode.com/problems/minimum-common-value/description/?envType=problem-list-v2&envId=binary-search
class Solution {
    public int getCommonBruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        for(int i = 0;i<n1;i++){
            for(int j =0;j<n2;j++){
                if(nums1[i]==nums2[j]) return nums2[j];
            }
        }
        return 0;
    }
}
public class Problem34 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3}, nums2 = {2,4};
        Solution s = new Solution();
        System.out.println("Brute Force:"+s.getCommonBruteForce(nums1,nums2));
    }
}
