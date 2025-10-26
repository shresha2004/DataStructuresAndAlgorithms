//Problem: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
import java.util.ArrayList;
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int[] isVis = new int[V];
        int[] pathVis = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges)
                adj.get(edge[0]).add(edge[1]);
            
        for(int i =0;i<V;i++){
            if(isVis[i]==0){
                if(dfs(adj,isVis,pathVis,i)) return true;
            }
        }
        return false;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] isVis,int[] pathVis,int node){
        isVis[node]=1;
        pathVis[node]=1;
        for(int neig : adj.get(node)){
            if(isVis[neig]==0){
                if(dfs(adj,isVis,pathVis,neig)) return true;
            }
            else if(pathVis[neig]==1) return true;
        }
        pathVis[node]=0;
        return false;
    }
}


public class Problem12 {
    public static void main(String[] args) {
       int V = 4, edges[][] ={{0, 1}, {1, 2}, {2, 0}, {2, 3}};
       Solution sol = new Solution();
       
       System.out.println("Solution:"+sol.isCyclic(V, edges));
    }
}
