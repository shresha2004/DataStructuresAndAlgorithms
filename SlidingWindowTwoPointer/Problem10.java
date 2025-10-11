//Problem:https://leetcode.com/problems/subarrays-with-k-different-integers/description/
import java.util.*;
class Solution{
 public int subarraysWithKDistinct(int[] nums, int k) {
       return helper(nums,k)-helper(nums,k-1);
    }
    private int helper(int[] nums,int k){
        if(k <=0) return 0;
         int n = nums.length;
      int left = 0;
      int right = 0;
      int count =0;
      HashMap<Integer,Integer> map = new HashMap<>();
      while(right < n){
        map.put(nums[right],map.getOrDefault(nums[right],0)+1);
        while(map.size()>k){
            map.put(nums[left],map.get(nums[left])-1);
            if(map.get(nums[left])==0) 
                map.remove(nums[left]);
            left++;
        }
        if(map.size()<=k) count+=(right-left)+1;
        right++;
      }
      System.out.println(count);
      return count;
    }
}
public class Problem10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println("Brute Force:"+s.subarraysWithKDistinct(nums, k));
        System.out.println("Optimal:"+s.subarraysWithKDistinct(nums, k));
    }
}
