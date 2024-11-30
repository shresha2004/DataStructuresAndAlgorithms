//Problem:https://leetcode.com/problems/3sum/description/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
class Solution {
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        int n=nums.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[k]);
                        Collections.sort(arr);
                        if(!ans.contains(arr))
                        ans.add(arr);
                    }
                }
            }
        }
        return ans;
    }
}
public class Problem34 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {-1,0,1,2,-1,-4};
    System.out.println("My Brute Force Approach:"+ s.threeSumBruteForce(nums).toString());
   
 
    }
}
