//Problem:https://www.geeksforgeeks.org/problems/topological-sort/1
import java.util.*;
class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i=0;i<V;i++) 
            adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        boolean[] isVis=new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!isVis[i])
                dfs(adj,isVis,st,i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty())
            ans.add(st.pop());
        return ans;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] isVis,Stack<Integer> st,int i){
        
        isVis[i]=true;
        for(int neigh : adj.get(i))
            if(!isVis[neigh]) dfs(adj,isVis,st,neigh);
        st.push(i);
    }
}
public class Problem13 {
    public static void main(String[] args) {
        int V = 4, E = 3, edges[][] = {{3, 0}, {1, 0}, {2, 0}};
        Solution sol = new Solution();
        System.out.println("Solution:"+sol.topoSort(V, edges));
    }
}
