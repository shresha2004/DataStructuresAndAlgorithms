//Problem:https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
import java.util.*;
class Pair{
    int node;
    int dist;
    Pair(int node , int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] ans = new int[V];
        
        //Step 1: Convert to adj list
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<Pair>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        
        //Step 2: find topological order
        Stack<Integer> topo = new Stack<>();
        boolean[] isVis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!isVis[i])
                dfs(i,topo,adj,isVis);
        }
       
        
        //Calculate distance 
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        
        while(!topo.isEmpty()){
            int node = topo.pop();
            ArrayList<Pair> p = adj.get(node);

            //Make sures topo start from source node, usually 0;
            if(distance[node] != Integer.MAX_VALUE){
            for(Pair neigh : p){
                if(distance[neigh.node] > distance[node]+neigh.dist ){
                    distance[neigh.node]=distance[node]+neigh.dist;
                }
            }
            }
        }
        for(int i=0;i<V;i++)     
            if(distance[i]==Integer.MAX_VALUE)
                distance[i]=-1;
        return distance;
    }
    
    private void dfs(int i,Stack<Integer> st,  ArrayList<ArrayList<Pair>> adj,boolean[] isVis){
        isVis[i]=true;
        for(Pair p : adj.get(i) )
            if(!isVis[p.node])
                dfs(p.node,st,adj,isVis);
        st.push(i);
    }
}
public class Problem16{
    public static void main(String[] args) {
       int V = 4, E = 2;
       int[][] edges = {{0,1,2}, {0,2,1}};
       Solution s = new Solution();
       System.out.println("Shortest Path:"+Arrays.toString(s.shortestPath(V, E, edges)));
    }
}