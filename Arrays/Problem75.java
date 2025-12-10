//Problem:https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        int len= indices.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<n;j++)
                matrix[indices[i][0]][j]+=1;
            for(int j=0;j<m;j++)
                matrix[j][indices[i][1]]+=1;
        }

        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]%2 != 0){
                    count++;
                }
            }
        }
        return count;
    }
}
public class Problem75 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int  m = 2, n = 3;
      int[][] indices = {{0,1},{1,1}};
      System.out.println("Solution:"+s.oddCells(m, n, indices));
    }
}
