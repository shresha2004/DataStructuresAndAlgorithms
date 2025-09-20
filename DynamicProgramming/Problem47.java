//Problem:https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
import java.util.*;
class Solution{
public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
      int[] lenArr = new int[n];
      int[] count = new int[n];
      Arrays.fill(lenArr,1);
      Arrays.fill(count,1);
      for(int index = 0;index<n;index++){
        for(int prev = 0;prev<index;prev++){
            if(nums[prev]<nums[index] && (1+lenArr[prev])>lenArr[index]){
                lenArr[index]=1+lenArr[prev];
                count[index]=count[prev];
            }
            else if(lenArr[prev]+1 ==lenArr[index])
                count[index]+=count[prev];
        }
      }
      int maxLen = 0;
      for(int i=0;i<n;i++){
        if(lenArr[i]>maxLen) maxLen = lenArr[i];
      }
      int cnt = 0;
      for(int i=0;i<n;i++){
        if(maxLen == lenArr[i]) cnt += count[i];
      }
   return cnt;
    }
}
public class Problem47 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,5,4,7};
        System.out.println("Solution:"+s.findNumberOfLIS(nums));
    }
}
