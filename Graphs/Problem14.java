//Problem:https://www.geeksforgeeks.org/problems/topological-sort/1
import java.util.*;
class Solution {
     public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
       for(int i=0;i<V;i++) adj.add(new ArrayList<>());
       
       for(int i=0;i<edges.length;i++){
           adj.get(edges[i][1]).add(edges[i][0]);
       }
       
       int[] inDegree = new int[V];
       for(int i=0;i<V;i++){
           for(int neigh : adj.get(i)){
               inDegree[neigh]++;
           }
       }
       Queue<Integer> q = new LinkedList<>();
       for(int i=0;i<V;i++)
            if(inDegree[i]==0) q.offer(i);
         
        ArrayList<Integer> ans = new ArrayList<>();
             
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(0,node);
            for(int neigh : adj.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.offer(neigh);
                } 
            }
        }
        
       return ans;
    }
}
public class Problem14 {
    public static void main(String[] args) {
        int V = 4, E = 3, edges[][] = {{3, 0}, {1, 0}, {2, 0}};
        Solution sol = new Solution();
        System.out.println("Solution:"+sol.topoSort(V, edges));
    }
}
