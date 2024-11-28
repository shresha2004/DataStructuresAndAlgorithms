//Problem:https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
import java.util.Arrays;
class Solution {
    public int maxFrequencyOptimal(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int maxFreq=0;
        long total=0;
        int left=0;

        for(int right=0;right<n;right++){
            total +=nums[right];

            while((long) nums[right] * (right-left + 1)  > total+k){
                total -= nums[left];
                left++;
            }
            maxFreq=Math.max(maxFreq, right-left+1);

        }
        return maxFreq;
    
    }
}
public class Problem32 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {1,4,8,13};
       int k = 5;

    System.out.println("Optimal Approach:"+(s.maxFrequencyOptimal(nums,k)));
 
    }
}
