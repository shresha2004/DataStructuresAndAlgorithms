//Problem:https://leetcode.com/problems/find-a-peak-element-ii/description/
package BinarySearch;
import java.util.Arrays;
class Solution {
    public int[] findPeakGridBruteForce(int[][] mat) {
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

    public int[] findPeakGridOptimal(int[][] mat) {
        int n = mat[0].length;
        int  low = 0;
        int high = n-1;
         while(low <= high){
            int mid = (low+high) >> 1;
            int row = findRow(mat,mid);
            int left = (mid-1>=0)? mat[row][mid-1] : -1;
            int right = (mid+1<n)?mat[row][mid+1] : -1;

            if(mat[row][mid]> left && mat[row][mid]>right) return new int[] {row,mid};
            else if(left>mat[row][mid]) high = mid-1;
            else low = mid+1;
         }

      return new int[] {-1,-1};
    }

    private int findRow(int[][] mat,int mid){
        int n = mat.length;
        int maxEle =-1;
        int index = -1;
        for(int i=0;i<n;i++){
            if(mat[i][mid]>maxEle){
                maxEle = mat[i][mid];
                index = i;
            }
        }
        return index;
    }
}
public class Problem41 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{1,4},{3,2}};
        System.out.println("Brute Force:"+Arrays.toString(s.findPeakGridBruteForce(mat)));
        System.out.println("Optimal:"+Arrays.toString(s.findPeakGridOptimal(mat)));
    }
}
