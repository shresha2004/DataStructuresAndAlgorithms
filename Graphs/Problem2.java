//Problem:https://leetcode.com/problems/number-of-provinces/description/
import java.util.*;

class Solution {
      public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m = isConnected.length;
        int n = isConnected[0].length;

        boolean[] isVisited = new boolean[m];
        int count=0;
        for(int i=0;i<m;i++){
        
        if(!isVisited[i]){
          bfs(isConnected,m,i,isVisited);
           count+=1;
        }
        }

        return count;
    }

    private void bfs(int[][] matrix, int V, int start,boolean[] isVisited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<matrix[0].length;i++){
                if( matrix[node][i]==1 && !isVisited[i]){
                    isVisited[i]=true;
                    q.offer(i);
                }
            }
        }
    }
}
public class Problem2 {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        Solution sol = new Solution();
        System.out.println("Solution:"+sol.findCircleNum(isConnected));
    }
}
