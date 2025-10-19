//Problem:https://leetcode.com/problems/surrounded-regions/description/
import java.util.*;
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public char[][] solve(char[][] board) {
      int m = board.length;
      int n = board[0].length;
      boolean[][] isVis = new boolean[m][n];
      for(int i=0;i<n;i++){
        if(board[0][i]=='O' && !isVis[0][i]){
           dfs(board,isVis,0,i,m,n) ;
        }
         if(board[m-1][i]=='O' && !isVis[m-1][i]){
            dfs(board,isVis,m-1,i,m,n);
        }
      }
    for(int i=0;i<m;i++){
        if(board[i][0]=='O' && !isVis[i][0]){
            dfs(board,isVis,i,0,m,n);
        }
        if(board[i][n-1]=='O' && !isVis[i][n-1]){
            dfs(board,isVis,i,n-1,m,n);
        }
       
      }
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(board[i][j]=='O' && isVis[i][j] != true){
                board[i][j]='X';
            }
        }
      }
      return board;
    }
    private void dfs(char[][] board,boolean[][] isVis, int Srow,int Scol,int m, int n){
      Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(Srow,Scol));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            isVis[cur.row][cur.col]=true;
            int[] dR = {-1,0,1,0};
            int[] dC = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int row = cur.row+dR[i];
                int col = cur.col + dC[i];
                if(col >= 0 && col<n && row >= 0 && row<m && board[row][col]=='O' && isVis[row][col]== false)
                    dfs(board,isVis,row,col,m,n);
            }
        }
    }
}

public class Problem6 {
   public static void main(String[] args) {
    char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
    Solution s = new Solution();
    System.out.println("Solution:"+Arrays.deepToString(s.solve(board)));
   } 
}
