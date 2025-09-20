//Problem:https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
import java.util.*;
class Solution{
public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int[] lenArr1 = new int[n];
        Arrays.fill(lenArr1,1);
        
        for(int index =0;index<n;index++){
            for(int prev = 0;prev<index;prev++){
                if(nums[prev]<nums[index] && (1+lenArr1[prev])>lenArr1[index]){
                    lenArr1[index]=lenArr1[prev]+1;
                }
            }
        }
        int[] lenArr2 = new int[n];
        Arrays.fill(lenArr2,1);
        
        for(int index =n-1;index>=0;index--){
            for(int prev =n-1;prev>index;prev--){
                if(nums[prev]<nums[index] && (1+lenArr2[prev])>lenArr2[index]){
                    lenArr2[index]=lenArr2[prev]+1;
                }
            }
        }
      int maxLen = 0;
      for(int i=0;i<n;i++){
          if(lenArr1[i]>1 && lenArr2[i]>1)
          maxLen = Math.max(maxLen,lenArr1[i]+lenArr2[i]-1);
      }
        return maxLen;

        }

}
public class Problem46 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,3,2,1};
        System.out.println("Solution:"+s.LongestBitonicSequence(7, nums));

    }
}
