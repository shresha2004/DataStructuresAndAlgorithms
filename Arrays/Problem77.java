//Problem:https://leetcode.com/problems/convert-1d-array-into-2d-array/description/
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
            if(len != m*n) return new int[][] {};
        int[][] matrix = new int[m][n];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(k<len)
                matrix[i][j]=original[k++];
            }
        }
        return matrix;
    }
}
public class Problem77 {
    public static void main(String[] args) {
      int[]  original = {1,2};
      int m = 1, n = 1;
      Solution s = new Solution();
      System.out.println("Solution:"+s.construct2DArray(original, m, n));
    }
}
