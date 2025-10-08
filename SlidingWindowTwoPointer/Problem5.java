//Problem:https://leetcode.com/problems/binary-subarrays-with-sum/description/
import java.util.*;
class Solution{
 public int numSubarraysWithSumBruteForce(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
            int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += nums[k];
                if (sum == goal)
                    count += 1;

            }
        }
        return count;
    }
     public int numSubarraysWithSumBetter(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum+=nums[j];
                if(sum == goal) count++;
             if(sum > goal) break;
            }
        }
        return count;
    }
     public int numSubarraysWithSumBetter2(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum-goal)){
                count +=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
     public int numSubarraysWithSumOptimal(int[] nums, int goal) {
       return atMost(nums,goal) - atMost(nums,goal-1);
    }
    private int atMost(int[] nums,int goal){
        if(goal < 0) return 0;
         int n = nums.length;
        int count = 0;
        int sum = 0;
       int left = 0;
       int right = 0;
       for(right = 0;right<n;right++){
        sum += nums[right];
         while(sum > goal)
            sum -= nums[left++];
       
         count += (right-left)+1;
       }
        return count;
    }
}
public class Problem5 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] nums = {1,0,1,0,1};
       int goal = 2;
        System.out.println("Brute Force:"+s.numSubarraysWithSumBruteForce(nums, goal));
        System.out.println("Better 1:"+s.numSubarraysWithSumBetter(nums, goal));
        System.out.println("Better 2:"+s.numSubarraysWithSumBetter2(nums, goal));
        System.out.println("Optimal:"+s.numSubarraysWithSumOptimal(nums, goal));
    }
}
