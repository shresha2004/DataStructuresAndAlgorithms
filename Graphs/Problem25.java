//Problem:https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
import java.util.*;
class Pair{
    int node;
    long wt;
    Pair(int node,long wt){
        this.node = node;
        this.wt = wt;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        final  int MOD = 1000000007;
        //Step 1:Convert to adj ArrayList
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());

        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        long[] distance = new long[n];
        int[] ways = new int[n];
            Arrays.fill(distance,Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.wt,b.wt));
        pq.offer(new Pair(0,0));
        distance[0]=0;
        ways[0]=1;
       ;
        while(!pq.isEmpty()){
            Pair curNode = pq.poll();
           
            for(Pair p : adj.get(curNode.node)){
                long dist = curNode.wt + p.wt;
                if(dist < distance[p.node]){
                    distance[p.node]=dist;
                    ways[p.node]=ways[curNode.node];
                    pq.offer(new Pair(p.node,dist));
                }
                else if(dist == distance[p.node]){
                    ways[p.node]=(ways[p.node]+ways[curNode.node])%MOD;
                }
            }
        }
        return ways[n-1]%MOD;
    }
}
public class Problem25 {
    public static void main(String[] args) {
       int n = 7;
       Solution s = new Solution();
       int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
       System.out.println("Number of shortest path:"+s.countPaths(n, roads));
       
    }
}
