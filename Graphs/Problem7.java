//Problem:https://leetcode.com/problems/number-of-enclaves/description/
import java.util.*;
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row =row;
        this.col= col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] isVis = new boolean[m][n];
    for(int i=0;i<n;i++){
        if(grid[0][i]==1){
            dfs(grid,isVis,0,i);
        }
        if(grid[m-1][i]==1){
            dfs(grid,isVis,m-1,i);
        }
    }
    for(int i=0;i<m;i++){
        if(grid[i][0]==1){
            dfs(grid,isVis,i,0);
        }
        if(grid[i][n-1]==1){
            dfs(grid,isVis,i,n-1);
        }
    }
    int count = 0;
    for(int i=1;i<m-1;i++){
        for(int j=1;j<n-1;j++){
            if(grid[i][j]==1 && !isVis[i][j]) count++;
        }
    }
    return count;
    }

    private void dfs(int[][] grid,boolean[][] isVis,int Sr,int Sc){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(Sr,Sc));
        isVis[Sr][Sc]=true;
        while(!q.isEmpty()){
            Pair node = q.poll();
            int[] dR ={-1,0,1,0};
            int[] dC ={0,1,0,-1};
            for(int i=0;i<4;i++){
                int row = node.row+dR[i];
                int col = node.col+dC[i];
                if(row >=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1 && !isVis[row][col]){
                    isVis[row][col]=true;
                    dfs(grid,isVis,row,col);
                }
            }
        }
    }
}
public class Problem7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println("Solution:"+s.numEnclaves(grid));
    }
}
