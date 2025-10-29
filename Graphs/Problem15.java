//Problem:https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
import java.util.*;
class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int V = adj.size();
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        distance[src]=0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            int dist = distance[node];
            
            for(int neigh : adj.get(node)){
                if(distance[neigh]>dist+1){
                    distance[neigh]=dist+1;
                    q.offer(neigh);
                }
            }
        }
        for(int i=0;i<V;i++)
            if(distance[i]==Integer.MAX_VALUE)
                distance[i]=-1;
        return distance;
    }
}
public class Problem15 {
    public static void main(String[] args) {
    int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);

      Solution s = new Solution();
      System.out.println("Solution:"+Arrays.toString(s.shortestPath(adj, 0)));
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // for undirected graph
    }
}
