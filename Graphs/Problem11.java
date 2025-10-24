//Problem:https://leetcode.com/problems/is-graph-bipartite/description/
import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
       int[] color = new int[V];
       Arrays.fill(color,-1);
       for(int i=0;i<V;i++){
       if(color[i]==-1){ 
        if(!dfs(graph,color,0,i)) return false;
       }
       }
       return true;
    }
    private boolean dfs(int[][] graph,int[] color,int col,int node){
        color[node]=col;
        for(int ele : graph[node]){
            if(color[ele]==-1){                
                if(!dfs(graph,color,1-col,ele)){
                     return false;
                }
            }
            else if(color[ele]==col) return false;
        }
        return true;
    }
}
public class Problem11 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println("Solution:"+s.isBipartite(graph));
    }
}
