//Problem:https://leetcode.com/problems/set-mismatch/description/?envType=problem-list-v2&envId=sorting
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] findErrorNumsBruteForce(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
         for(int i = 0;i<n;i++){
               if(map.get(nums[i])>1) ans[0] = nums[i];
                if(!map.containsKey(i+1)) ans[1] = i+1;
           
        }
       
       
        return ans;
    }
}


public class Problem52 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,2,4};
        System.out.println("Brute Force:"+Arrays.toString(s.findErrorNumsBruteForce(nums)));
    }
}
