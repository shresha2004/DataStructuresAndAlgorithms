//Problem:https://leetcode.com/problems/find-a-peak-element-ii/description/
package BinarySearch;
import java.util.Arrays;
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[2];
         int max = -1;

        for(int i=0;i<m;i++){
           
            for(int j=0;j<n;j++){
              if(mat[i][j]>max){
                max=mat[i][j];
                ans[0]=i;
                ans[1]=j;
              }
            }
        }

        return ans;
    }
}
public class Problem41 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{1,4},{3,2}};
        System.out.println("Brute Force:"+Arrays.toString(s.findPeakGrid(mat)));
    }
}
