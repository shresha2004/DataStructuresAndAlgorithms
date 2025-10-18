//Problem:https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
import java.util.*;

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[V];
        dfsTraverse(adj,V,0,ans,isVisited);
        return ans;
    }
    
    private void dfsTraverse(ArrayList<ArrayList<Integer>> adj,int V,int curV,ArrayList<Integer> ans,boolean[] isVisited){
        if(curV == V) return;
        Queue<Integer> q = new LinkedList<>();
        q.offer(curV);
        
        while(!q.isEmpty()){
            int node = q.poll();
            isVisited[node]=true;
            ans.add(node);
            for(int ele : adj.get(node)){
                if(!isVisited[ele])
                dfsTraverse(adj,V,ele,ans,isVisited);
            }
            
        }
    }
}
public class DFSTraversal {
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

       System.out.println(adj);
        Solution sol = new Solution();
        System.out.println("Solution:"+sol.dfs(adj));
       
    }

    // Helper function to add edges
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // for undirected graph
    }
}
