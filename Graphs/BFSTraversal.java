//Problem: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
import java.util.*;

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfsAns = new ArrayList<>();
        int vertex = adj.size();
        int[] isVisited = new int[vertex];
        Queue<Integer> q = new LinkedList<>();
    //Initialization
        q.offer(0);
        isVisited[0]=1;
       
        while(!q.isEmpty()){
            int node = q.poll();
            
            bfsAns.add(node);
            for(int ele: adj.get(node)){
                if(isVisited[ele] != 1){
                    isVisited[ele]=1;
                    q.offer(ele);
                }
            }
        }
        return bfsAns;
    }
}
public class BFSTraversal {
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

        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        Solution sol = new Solution();
        ArrayList<Integer> bfsTraversal = sol.bfs(adj);

        System.out.println("\nBFS Traversal starting from node 0:");
        System.out.println(bfsTraversal);
    }

    // Helper function to add edges
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // for undirected graph
    }
}
