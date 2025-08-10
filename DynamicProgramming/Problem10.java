//Problem:https://leetcode.com/problems/unique-paths-ii/description/
class Solution {
    public int uniquePathsWithObstaclesRecursive(int[][] obstacleGrid) {
        int row = obstacleGrid.length-1;
        int column = obstacleGrid[0].length-1;
        return countPathRecursive(row,column,obstacleGrid);
    }

    private int countPathRecursive(int row,int column,int[][] grid){
        if(row <0 || column < 0) return 0;
        if(grid[row][column]==1) return 0;
        if(row==0 && column == 0) return 1;
        int left =countPathRecursive(row-1,column,grid);
        int right = countPathRecursive(row,column-1,grid);
        return left + right;
    }
     public int uniquePathsWithObstaclesMemoization(int[][] obstacleGrid) {
        int row = obstacleGrid.length-1;
        int column = obstacleGrid[0].length-1;
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++)
            for(int j=0;j<obstacleGrid[0].length;j++)
                memo[i][j]=-1;
        return countPathMemo(row,column,obstacleGrid,memo);
    }

    private int countPathMemo(int row,int column,int[][] grid,int[][] memo){
        if(row <0 || column < 0) return 0;
        if(grid[row][column]==1) return 0;
        if(memo[row][column] != -1) return memo[row][column];
        if(row==0 && column == 0) return 1;
        int left =countPathMemo(row-1,column,grid,memo);
        int right = countPathMemo(row,column-1,grid,memo);
        return memo[row][column]=left + right;
    }
     public int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid) {
        int row = obstacleGrid.length - 1;
        int column = obstacleGrid[0].length - 1;
        int[][] tabu = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    tabu[i][j] = 0;
                    continue;
                } else if (i == 0 && j == 0)
                    tabu[0][0] = 1;

                else {
                    int left = 0;
                    int right = 0;
                    if (i > 0)
                        left = tabu[i - 1][j];
                    if (j > 0)
                        right = tabu[i][j - 1];
                    tabu[i][j] = left + right;
                }
            }
        }
        return tabu[row][column];
    }
     public int uniquePathsWithObstaclesSpaceOptimization(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[] spo = new int[obstacleGrid[0].length];
        for (int i = 0; i < row; i++) {
            int[] temp = new int[obstacleGrid[0].length];
            for (int j = 0; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                    
                } else if (i == 0 && j == 0)
                   temp[j] = 1;

                else {
                 if(j>0) temp[j]=temp[j-1];
                 temp[j]+=spo[j];
                }
            }
            spo=temp;
        }
        return spo[column-1] ;
           }

}
public class Problem10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("Recursive:"+s.uniquePathsWithObstaclesRecursive(obstacleGrid));
        System.out.println("Memoization:"+s.uniquePathsWithObstaclesMemoization(obstacleGrid));
        System.out.println("Tabulation:"+s.uniquePathsWithObstaclesTabulation(obstacleGrid));
        System.out.println("Space Optimization:"+s.uniquePathsWithObstaclesSpaceOptimization(obstacleGrid));
    }
}
