//Problem:https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
import java.util.*;
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        
        dist[src]=0;
        for(int j=0;j<V-1;j++){
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt = edges[i][2];
            if(dist[u] != 1e8 && dist[u]+wt < dist[v])
                dist[v]=dist[u]+wt ;
        }
        }
      
            for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt = edges[i][2];
            if(dist[u] != 1e8 && dist[u]+wt < dist[v])
                return new int[] {-1};
            }
        
        return dist;
    }
}

public class Problem31 {
    public static void main(String[] args) {
       int V = 5, edges[][] = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}}, src = 0;
       Solution s = new Solution();
       
       System.out.println("Answer:"+Arrays.toString(s.bellmanFord(V, edges, src)));
    }
}
