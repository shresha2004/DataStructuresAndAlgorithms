//Problem:https://leetcode.com/problems/network-delay-time/
import java.util.*;
class Pair{
    int node;
    int dist;
    float wt;
    Pair(int node,float wt){
        this.node = node;
        this.wt = wt;
    }
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       //Step 1: Convert times to adj ArrayList
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>() ;
       for(int i=0;i<=n;i++)
            adj.add(new ArrayList<Pair>());

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],(float) times[i][2]));
        }

        //Step 2: Initialize distance array to track mins
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        
        
        //Step 3: Initialize Priority queue to track minimum dist
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist-b.dist);
        distance[k]=0;
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            ArrayList<Pair> neighs = adj.get(cur.node);
            for( Pair neigh : neighs){
                int newDist = (int) neigh.wt + cur.dist;
                if(newDist < distance[neigh.node]){
                    distance[neigh.node]=newDist;
                    pq.offer(new Pair(neigh.node,newDist));
                }
            }
        }
        int maxTime = 0;
        for(int i=1;i<distance.length;i++){
            if(distance[i]==Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime,distance[i]);
        }
            
        return maxTime;
    }
}
public class Problem18 {
    public static void main(String[] args) {
      int[][]  times = {{2,1,1},{2,3,1},{3,4,1}};
      int n = 4, k = 2;
      Solution s = new Solution();
      System.out.println("Dijsktra's Algorithm:"+s.networkDelayTime(times, n, k));
    }
}
