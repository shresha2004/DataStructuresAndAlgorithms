//Problem:https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
import java.util.ArrayList;
import java.util.HashSet;
class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVis = new boolean[m][n];
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !isVis[i][j]){
                    ArrayList<String> shape = new ArrayList<>();
                   
                   isVis[i][j]=true;
                   shape.add(0+":"+0);
                    dfs(grid,i,j,isVis,m,n,i,j,shape);
                   set.add(String.join(",",shape));
                }
            }
        }
        
        return set.size();
    }
    private void dfs(int[][] grid, int i,int j,boolean[][] isVis,int m,int n,int baseRow,int baseCol,ArrayList<String> shape){
        
        
        
            int[] dR = {-1,0,1,0};
            int[] dC = {0,1,0,-1};
            for(int a=0;a<4;a++){
                int row = i+dR[a];
                int col = j+dC[a];
                if(row >= 0 && row < m && col >=0 && col<n && grid[row][col] ==1 && !isVis[row][col] ){
                    isVis[row][col]=true;
                    shape.add((row-baseRow)+":"+(col-baseCol));
                    dfs(grid,row,col,isVis,m,n,baseRow,baseCol,shape);
                }
            }
            return;
        }
    }



public class Problem10 {
    public static void main(String[] args) {
       int[][] grid = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}};

        Solution sol = new Solution();
        System.out.println("Solution:"+sol.countDistinctIslands(grid));
    }
}
