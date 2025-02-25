import java.util.HashSet;
//Problem:https://leetcode.com/problems/first-missing-positive/description/
//I choosed question
class Solution {
    public int firstMissingPositiveBruteForce(int[] nums) {
        int n = nums.length;
      
        HashSet<Integer> set = new HashSet<>();
        for(int i =0 ;i<n;i++){
            set.add(nums[i]);
        }
        
        for(int i = 0; i<=n;i++){
            if(!set.contains(i+1)) return i+1;
        }
        return 0;
    }
    public int firstMissingPositiveOptimal(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
           while(nums[i]>0 && nums[i]<=n && nums[i] !=nums[nums[i]-1] ){
            int temp = nums[i];
            nums[i] = nums[temp-1];
            nums[temp-1]=temp;
           }
        }
        for(int i = 0;i<n;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return n+1;
    }
}
public class Problem54 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,4,-1,1};
        System.out.println("My Brute Force:"+(s.firstMissingPositiveBruteForce(nums)));
        System.out.println("Optimal:"+(s.firstMissingPositiveBruteForce(nums)));
    }
}
