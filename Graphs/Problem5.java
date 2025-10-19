//Problem:https://leetcode.com/problems/01-matrix/description/
import java.util.*;
class Pair{
    int row = 0;
    int col = 0;
    Pair(int row,int col ){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] isVis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
        if(mat[i][j]==0){
                isVis[i][j]=true;
                q.offer(new Pair(i,j));
        }
        }
        
        }
        bfs(mat,m,n,isVis,q);
      
        return mat;
    }
    private void bfs(int[][] mat,int m,int n,boolean[][] isVis,Queue<Pair> q){
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int[] dR = {-1,0,1,0};
            int[] dC = {0,1,0,-1};
            for(int i = 0;i<4;i++){
                int row = cur.row + dR[i];
                int col = cur.col + dC[i];
                if(row >=0 && row <m && col >=0 && col < n &&  isVis[row][col]==false){
                    mat[row][col]=mat[cur.row][cur.col]+1;
                    isVis[row][col]=true;
                    q.offer(new Pair(row,col));
                }
                
            }
        }
    }
}
public class Problem5 {
    public static void main(String[] args) {
        int[][] mat ={{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        Solution sol = new Solution();
        System.out.println("Solution:"+Arrays.deepToString(sol.updateMatrix(mat)));
    }
}
