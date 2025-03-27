//Problem:https://leetcode.com/problems/single-number-ii/description/?envType=problem-list-v2&envId=array
import java.util.HashMap;
class Solution {
    public int singleNumberBruteForce(int[] nums) {
        int n = nums.length;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i : nums){
        map.put(i,map.getOrDefault(i,0)+1);
       }
      for(int i : nums){
        if(map.get(i)==1) return i;
      }
      return 0; 
    }
}
public class Problem64 {
 public static void main(String[] args) {
    int[]  nums = {2,2,3,2};
    Solution s = new Solution();
    System.out.println("Brute Force:"+s.singleNumberBruteForce(nums));
 }   
}
