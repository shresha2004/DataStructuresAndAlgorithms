//Problem:https://leetcode.com/problems/minimum-falling-path-sum/description/
class Solution {
    public int minFallingPathSumRecursive(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int minPath = Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            minPath = Math.min(minPath,minPathRecursive(row-1,i,matrix));
        }
        return minPath;
    }
    private int minPathRecursive(int row, int column,int[][] matrix){
        if(row == 0) return matrix[row][column];
        int path1 = Integer.MAX_VALUE;
        int path2 = Integer.MAX_VALUE;
        int path3 = Integer.MAX_VALUE;
        if(column>0) path1 = matrix[row][column]+ minPathRecursive(row-1,column-1,matrix);
        if(column <matrix[0].length-1) path2 = matrix[row][column]+minPathRecursive(row-1,column+1,matrix);
        path3 = matrix[row][column]+minPathRecursive(row-1,column,matrix);
        return Math.min(path1,Math.min(path2,path3));
    }

     public int minFallingPathSumMemoization(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int minPath = Integer.MAX_VALUE;
        int[][] memo = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++)
             memo[i][j]=Integer.MAX_VALUE;
        }
        for(int i=0;i<row;i++){
            minPath = Math.min(minPath,minPathMemo(row-1,i,matrix,memo));
        }
        return minPath;
    }
    private int minPathMemo(int row, int column,int[][] matrix,int[][] memo){
        if(memo[row][column] != Integer.MAX_VALUE) return memo[row][column];
        if(row == 0) return matrix[row][column];
        int path1 = Integer.MAX_VALUE;
        int path2 = Integer.MAX_VALUE;
        int path3 = Integer.MAX_VALUE;
        if(column>0) path1 = matrix[row][column]+ minPathMemo(row-1,column-1,matrix,memo);
        if(column <matrix[0].length-1) path2 = matrix[row][column]+minPathMemo(row-1,column+1,matrix,memo);
        path3 = matrix[row][column]+minPathMemo(row-1,column,matrix,memo);
        return memo[row][column]=Math.min(path1,Math.min(path2,path3));
    }

     public int minFallingPathSumTabulation(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int minPath = Integer.MAX_VALUE;
        int[][] tabu = new int[row][column];
        for(int i=0;i<column;i++)
            tabu[0][i]=matrix[0][i];
        for(int i=1;i<row;i++){
            for(int j=0;j<column;j++){
               int path1 = Integer.MAX_VALUE;
               int path2 = Integer.MAX_VALUE;
               int path3 = Integer.MAX_VALUE;
               if(j>0) path1 = tabu[i-1][j-1]+matrix[i][j];
               if(j<column-1) path2 = tabu[i-1][j+1]+matrix[i][j];
               path3 = tabu[i-1][j]+matrix[i][j];
               tabu[i][j]=Math.min(path1,Math.min(path2,path3));
            
            }
        }
        for(int i=0;i<column;i++) minPath = Math.min(minPath,tabu[row-1][i]);
        return minPath;
    }
}
public class Problem13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix =  {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("Recursive:"+s.minFallingPathSumRecursive(matrix));
        System.out.println("Memoization:"+s.minFallingPathSumRecursive(matrix));
        System.out.println("Tabulation:"+s.minFallingPathSumTabulation(matrix));

    }
}
