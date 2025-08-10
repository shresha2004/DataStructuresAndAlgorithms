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
}
public class Problem10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("Recursive:"+s.uniquePathsWithObstaclesRecursive(obstacleGrid));
        System.out.println("Memoization:"+s.uniquePathsWithObstaclesMemoization(obstacleGrid));
        
    }
}
