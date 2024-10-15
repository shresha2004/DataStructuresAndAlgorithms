//Problem:https://leetcode.com/problems/contains-duplicate-ii/description/?envType=problem-list-v2&envId=sliding-window
import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0;
        
        boolean present=false;
        HashMap<Integer,Integer> hash= new HashMap<>();
        int n=nums.length;
        while(l<n){
        if(hash.containsKey(nums[l]) && l-hash.get(nums[l])<=k){
            present=true;
            break;
        }
             
            hash.put(nums[l],l);
            l++;
        }

        return present;
        
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={1,2,3,1};
      System.out.println( s.containsNearbyDuplicate(a, 3)); 
    }
}
