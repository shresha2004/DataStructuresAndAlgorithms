//Problem:https://leetcode.com/problems/rotting-oranges/description/
import java.util.*;

class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRottingMyApproach(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int row= grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2) q.offer(new Pair(i,j,0));
            }
        }
        int[] Time = {0};
        bfs(grid,Time,q);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return Time[0];
    }
    private void bfs(int[][] grid,int[] Time,Queue<Pair> q){
        while(!q.isEmpty()){
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            int time = node.time;
            Time[0]= Math.max(Time[0],time);
            if(row > 0 && grid[row-1][col]==1){
                grid[row-1][col]=2;
                q.offer(new Pair(row-1,col,time+1));
            }
            if(col > 0 && grid[row][col-1]==1){
                grid[row][col-1]=2;
                q.offer(new Pair(row,col-1,time+1));

            }
            if(row<grid.length-1 && grid[row+1][col]==1){
                grid[row+1][col]=2;
                q.offer(new Pair(row+1,col,time+1));
            }
            if(col < grid[0].length-1 && grid[row][col+1]==1){
                grid[row][col+1] = 2;
                q.offer(new Pair(row,col+1,time+1));
            }
        }
    }
    public int orangesRottingActual(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int row= grid.length;
        int col = grid[0].length;
        int fresh = 0;
        boolean[][] isVis = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) fresh+=1;
                if(grid[i][j]==2) q.offer(new Pair(i,j,0));
            }
        }
        int[] Time = {0};
        int[] rotten = {0};
        bfs(grid,Time,q,rotten,isVis);
       if(rotten[0] != fresh) return -1;
        return Time[0];
    }
    private void bfs(int[][] grid,int[] Time,Queue<Pair> q,int[] rotten,boolean[][] isVis){
        while(!q.isEmpty()){
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            int time = node.time;
            Time[0]= Math.max(Time[0],time);
            int[] nR = {-1,0,1,0};
            int[] nC = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int nextR = row + nR[i];
                int nextC = col + nC[i];
                if(nextR >= 0 && nextR < grid.length && nextC >=0 && nextC < grid[0].length  && grid[nextR][nextC]==1 && isVis[nextR][nextC]==false){
                    isVis[nextR][nextC]=true;
            rotten[0]+=1;
                    q.offer(new Pair(nextR,nextC,time+1));
                }
            }
        }
    }
}
public class Problem3 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        Solution sol = new Solution();
        System.out.println("Solution 1:"+sol.orangesRottingMyApproach(grid));
        System.out.println("Solution 2:"+sol.orangesRottingActual(grid));
    }
}
