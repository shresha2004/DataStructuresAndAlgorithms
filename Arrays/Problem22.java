//Problem:https://leetcode.com/problems/contains-duplicate/description/?envType=problem-list-v2&envId=array&difficulty=EASY
import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public boolean containsDuplicateBruteForce(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]) return true;
            }
        }
     return false;   
    }

    public boolean containsDuplicateBetter(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>1){
                return true;
            }

        }
     return false;   
    }

    public boolean containsDuplicateOptimal(int[] nums) {
        int len=nums.length;
       HashSet<Integer> set= new HashSet<>();
        for(int num: nums){
            if(!set.add(num)){
                return true;
            }
        }  
     return false;   
    }
}

public class Problem22 {
     public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {1,2,3,1};
      System.out.println("BruteForce Approach:"+s.containsDuplicateBruteForce(nums));
     System.out.println("Better Approach:"+s.containsDuplicateBetter(nums));
     System.out.println("Optimal Approach:"+s.containsDuplicateOptimal(nums));
    }
}
