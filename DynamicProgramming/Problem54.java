//Problem:https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
class Solution{
 public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][0]=matrix[i][0];
        for(int j=0;j<n;j++)
            dp[0][j]=matrix[0][j];

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }else dp[i][j]=0;
            }
        }
        int sum=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                sum += dp[i][j];
        return sum;
    }
}
public class Problem54 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix ={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println("Solution:"+s.countSquares(matrix));

    }
}
