//Problem:https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
import java.util.*;
class Pair{
    int weight;
    int node;
    Pair(int node,int weight){
        this.weight = weight;
        this.node = node;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        //Make adj arraylist
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<Pair>());
            
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        int[] parent = new int[V];
        for(int i=0;i<V;i++)
            parent[i]=i;
        
        distance[src]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.weight - b.weight);
        pq.offer(new Pair(src,0));
       
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            ArrayList<Pair> p = adj.get(cur.node);
            if(cur.weight > distance[cur.node]) continue;
            for(Pair neigh : p){
                if((cur.weight+neigh.weight) < distance[neigh.node]){
                distance[neigh.node]=cur.weight+neigh.weight;
                pq.offer(new Pair(neigh.node,cur.weight+neigh.weight));
                parent[neigh.node]=cur.node;
           
                }
            }
        }
    return distance;
    }
}
public class Problem17 {
    public static void main(String[] args) {
        int V = 3;
        int edges[][] = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        int src = 2;
        Solution s = new Solution();
        System.out.println("Solution:"+Arrays.toString(s.dijkstra(V, edges, src)));
    }
}
