//Problem:https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
import java.util.*;
class Pair{
    int node;
    float wt;
    int dist;
    int stops;
    Pair(int node,float wt){
        this.node=node;
        this.wt = wt;
    }
    Pair(int node,int dist,int stops){
        this.node=node;
        this.dist = dist;
        this.stops =stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Step 1 : Convert to adjecency ArrayList
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());

        for(int i=0;i<flights.length;i++)
            adj.get(flights[i][0]).add(new Pair(flights[i][1],(float)flights[i][2]));
        
      Queue<Pair> pq = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        pq.offer(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair curNode = pq.poll();
            if(curNode.stops > k) continue;
           
          
            for(Pair p: adj.get(curNode.node)){
               int dist = curNode.dist +(int) p.wt;
               if(dist < distance[p.node] && curNode.stops <= k){
                distance[p.node]=dist;
                pq.offer(new Pair(p.node,dist,curNode.stops+1));
               }
            }
        }
        return (distance[dst]==Integer.MAX_VALUE)?-1:distance[dst];
    }
}
public class Problem23 {
    public static void main(String[] args) {
      int  n = 4;
      int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
      int src = 0, dst = 3, k = 1;
      Solution s = new Solution();
      System.out.println("Solution:"+s.findCheapestPrice(n, flights, src, dst, k));
    }
}
