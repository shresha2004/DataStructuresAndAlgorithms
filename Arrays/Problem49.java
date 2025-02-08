//Problem:https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
class Solution {
    public List<Integer> findDisappearedNumbersBruteForce(int[] nums) {
        int n =  nums.length;
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        for(int i = 1;i<=n;i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }

    //Index matching approach
    public List<Integer> findDisappearedNumbersOptimal(int[] nums) {
        int n =  nums.length;
        List<Integer> ans = new ArrayList<>();
       
       for(int num :nums){
        int index = Math.abs(num)-1;
       if(nums[index] > 0) nums[index] = - nums[index];
       }
       for(int i = 0;i<n;i++){
        if(nums[i]>0) ans.add(i+1);
       }
       
        return ans;
    }
   
}
public class Problem49 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println("Brute Force:"+s.findDisappearedNumbersBruteForce(nums));
        System.out.println("Optimal:"+s.findDisappearedNumbersOptimal(nums));
    }
}
