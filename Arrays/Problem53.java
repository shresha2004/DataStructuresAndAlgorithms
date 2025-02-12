import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//Problem:https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
//I choosed question
class Solution {
    public List<Integer> findDuplicatesBruteForce(int[] nums) {
        int n =  nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>1) ans.add(nums[i]);
        }
        return ans;
    }
}

public class Problem53 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println("My Brute Force:"+(s.findDuplicatesBruteForce(nums)));
    }
}
