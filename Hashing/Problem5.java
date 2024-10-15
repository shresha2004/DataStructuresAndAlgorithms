//Problem:https://leetcode.com/problems/longest-harmonious-subsequence/description/?envType=problem-list-v2&envId=sliding-window
import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }
        
        for(int key : map.keySet()){
            if(map.containsKey(key+1)){
                int length=map.get(key)+map.get(key+1);
                maxLength=Math.max(maxLength,length);
            }

        }
       return maxLength; 
    }
}
public class Problem5 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={1,3,2,2,5,2,3,7};
       System.out.println(s.findLHS(a)); 
    }
    
}
