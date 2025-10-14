
//Problem:https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                bfs(i, adj, isVisited, ans, comp);
                ans.add(comp);
            }
        }

        return ans;
    }

    private void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited,
            ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> comp) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            comp.add(node);

            for (int ele : adj.get(node)) {
                if (!isVisited[ele]) {
                    q.offer(ele);
                    isVisited[ele] = true;
                }
            }
        }
    }
}

public class Problem1 {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 0, 1 }, { 2, 1 }, { 3, 4 } };

        Solution sol = new Solution();
        System.out.println("Solution:"+sol.getComponents(V, edges));
    }

}
