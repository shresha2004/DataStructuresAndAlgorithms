//Problem:https://leetcode.com/problems/rotate-array/description/
import java.util.Arrays;
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        System.err.println(Arrays.toString(nums));    
    }
    public void reverse(int nums[],int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
public class Problem4Solution2 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] a={1,2,3,4,5,6,7};
        s.rotate(a, 3);
        
    }
    
}
