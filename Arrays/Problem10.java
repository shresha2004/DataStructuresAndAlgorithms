//Problem:https://leetcode.com/problems/single-number/description/
import java.util.HashMap;
class Solution {
    public int singleNumberBruteForce(int[] nums) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        int n=nums.length;
        int onlyOne=nums.length;
        for(int num: nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        
        for(int i=0;i<n;i++){
            if(hash.get(nums[i])==1){
                onlyOne=nums[i];
                break;
            }
        }
        
       return onlyOne; 
    }
    public int singleNumberOptimal(int[] nums) {
        
       int result=0;
       for(int num : nums){
        result ^= num;
       }
        
       return result; 
    }
}
public class Problem10 {
public static void main(String[] args) {
    Solution s=new Solution();
        int[] nums = {4,1,2,1,2};
        System.out.println("Brute Force Solution:"+s.singleNumberBruteForce(nums));
        System.out.println("Optimal Solution:"+s.singleNumberOptimal(nums));
    
}
}
