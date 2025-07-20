package BinarySearch;
//Problem:https://leetcode.com/problems/minimum-common-value/description/?envType=problem-list-v2&envId=binary-search
//I choosed question
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

    public int getCommonBetter(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        

        for(int i = 0;i<n1;i++){
            int low = 0;
        int high = n2-1;
            while(low <= high){
                int mid = (low+high)/2;
                if(nums1[i] == nums2[mid]) return  nums2[mid];
               else if(nums1[i]<nums2[mid]) high = mid-1;
               else low = mid+1;
                
            }
        }
        return -1;
    }
    public int getCommonOptimal(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = 0;
        int right = 0;

        while(left < n1 && right <n2){
            if(nums1[left]==nums2[right]) return nums1[left];
            else if(nums1[left]<nums2[right]) left++;
            else right++;
        }
        return -1;
    }
}
public class Problem34 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3}, nums2 = {2,4};
        Solution s = new Solution();
        System.out.println("My Brute Force:"+s.getCommonBruteForce(nums1,nums2));
        System.out.println("My Better:"+s.getCommonBetter(nums1,nums2));
        System.out.println("My Optimal:"+s.getCommonOptimal(nums1,nums2));
    }
}
