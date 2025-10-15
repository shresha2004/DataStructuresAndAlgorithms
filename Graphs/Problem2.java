//Problem:https://leetcode.com/problems/number-of-provinces/description/
import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m = isConnected.length;
        int n = isConnected[0].length;
        for(int i=0;i<m;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    int u=i;
                    int v = j;
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
        boolean[] isVisited = new boolean[m];
        int count=0;
        for(int i=0;i<m;i++){
        
        if(!isVisited[i]){
          bfs(adj,m,i,isVisited);
           count+=1;
        }
        }

        return count;
    }

    private void bfs(ArrayList<ArrayList<Integer>> adj, int V, int start,boolean[] isVisited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next: adj.get(node)){
                if(!isVisited[next]){
                    isVisited[next]=true;
                    q.offer(next);
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
