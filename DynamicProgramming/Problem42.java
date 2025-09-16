//Problem:https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1

import java.util.Arrays;

class Solution{
  public int lengthOfLISTabu(int[] nums) {
        int n = nums.length;
        int[][] tabu = new int[n+1][n+1];
        for(int index = n-1;index>=0;index--){
            for(int prevIndex = index-1;prevIndex>=-1;prevIndex--){
                int notTake = 0+tabu[index+1][prevIndex+1];
                int take= 0;
                if(prevIndex == -1 || nums[index]>nums[prevIndex]){
                   take = 1+tabu[index+1][index+1];
                }
                tabu[index][prevIndex+1]=Math.max(take,notTake);
            }
        }
        System.out.println(Arrays.deepToString(tabu));
        return tabu[0][0];
    }
}
public class Problem42 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int arr[] = {10, 20, 3, 40};
        System.out.println(s.lengthOfLISTabu(arr));

    }
}
