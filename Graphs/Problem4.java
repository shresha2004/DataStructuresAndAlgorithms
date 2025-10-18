
//Problem:https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
import java.util.*;

class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int m = edges.length;
        int n = edges[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] isVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVis[i]) {
                if (bfs(i, adj, isVis))
                    return true;
            }

        }
        return false;

    }

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] isVis) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, -1));
        isVis[start] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int node = cur.node;
            int parent = cur.parent;

            for (int ele : adj.get(node)) {
                if (isVis[ele] == false) {
                    q.offer(new Pair(ele, node));
                    isVis[ele] = true;
                } else if (parent != ele) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Problem4 {
    public static void main(String[] args) {
        int V = 4; 
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        Solution sol = new Solution();
        System.out.println("Solution:" + sol.isCycle(V, edges));

    }

}
