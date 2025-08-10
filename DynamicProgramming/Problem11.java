//Problem:https://leetcode.com/problems/minimum-path-sum/
class Solution {
    public int minPathSumRecursive(int[][] grid) {
        int row = grid.length-1;
        int column = grid[0].length-1;
        return sumPathRecursive(row,column,grid);
    }

    private int sumPathRecursive(int row,int column,int[][] grid){
        if(row < 0 || column < 0) return 1_000_000_000;
        if(row == 0 && column == 0) return grid[row][column];
        int left = grid[row][column]+sumPathRecursive(row-1,column,grid);
        int right = grid[row][column]+sumPathRecursive(row,column-1,grid);
        return Math.min(left,right);
    }


     public int minPathSumMemoization(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] memo = new int[row][column];
        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
                memo[i][j]=-1;
        return sumPathMemo(row-1,column-1,grid,memo);
    }

    private int sumPathMemo(int row,int column,int[][] grid,int[][] memo){
        if(row < 0 || column < 0) return 1_000_000_000;
        if(row == 0 && column == 0) return grid[row][column];
        if(memo[row][column] != -1) return memo[row][column];
        int left = grid[row][column]+sumPathMemo(row-1,column,grid,memo);
        int right = grid[row][column]+sumPathMemo(row,column-1,grid,memo);
        return memo[row][column]=Math.min(left,right);
    }


    public int minPathSumTabulation(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] tabu = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0)
                    tabu[i][j] = grid[i][j];
                else {
                    int left =Integer.MAX_VALUE;
                    int right = Integer.MAX_VALUE;
                   if(i>0)  left = grid[i][j] + tabu[i-1][j];
                    if(j>0) right = grid[i][j] + tabu[i][j-1];
                    tabu[i][j]=Math.min(left,right);
                }
            }
        }
        return tabu[row - 1][column - 1];
    }
     public int minPathSumSpaceOptimization(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[] spo = new int[column];
        for (int i = 0; i < row; i++) {
            int[] temp = new int[column];
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0)
                  temp[j]=grid[i][j];
                else {
                    int right = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                   if(j>0) left = temp[j-1]+grid[i][j];
                  if(i>0) right = spo[j]+grid[i][j];
                  temp[j]=Math.min(left,right);
                }
            }
            spo=temp;
        }
        return spo[column-1];
    }
}
public class Problem11 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Recursion:"+s.minPathSumRecursive(grid));
        System.out.println("Memoization:"+s.minPathSumMemoization(grid));
        System.out.println("Tabulation:"+s.minPathSumTabulation(grid));
        System.out.println("Space Optimization:"+s.minPathSumSpaceOptimization(grid));
    }
}
