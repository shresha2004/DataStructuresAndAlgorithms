package BinarySearch;
//Problem:https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
import java.util.Arrays;
class Solution {
    public int[] searchRangeBruteForce(int[] nums, int target) {
        int n = nums.length;
        int flag =0;
        int start = -1;
        int end = -1;
        int[] ans = new int[2];

        for(int i =0; i<n; i++){
            if(nums[i]==target && flag==0){
                start = i;
                flag = 1;
            }
            if(nums[i] == target && i== n-1){
                end = i;
                break;
            }
            if(nums[i] != target && flag==1){
                end = i-1;
                break;
            }
        }
        ans[0] = start;
        ans[1] = end;

        return ans;
        
    }
}
public class Problem6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println("My Bruteforce:"+ Arrays.toString(s.searchRangeBruteForce(nums, target)));
    }
    
}
