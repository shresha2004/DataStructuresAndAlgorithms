//Problem:https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
class DisjointSet{
    int[] parent;
    int[] rank;
    DisjointSet(int n){
    parent = new int[n];
    rank = new int[n];
    for(int i=0;i<n;i++)
        parent[i]=i;
    }

  public int  findPar(int u){
        if(parent[u]==u)
            return u;
        return parent[u]=findPar(parent[u]);
    }
    public void unionSet(int u,int v){
        int leaderU = findPar(u);
        int leaderV= findPar(v);
        if(leaderU == leaderV){
          
             return;
        }
        if(rank[leaderU]<rank[leaderV]){
            parent[leaderU]=leaderV;
        }
        else if(rank[leaderV]<rank[leaderU]){
            parent[leaderV]=leaderU;
        }
        else{
            parent[leaderU]=leaderV;
            rank[leaderV]+=1;
        }
    }

}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra =0;
        for(int i=0;i<connections.length;i++){
            //to find extra edges
            if(ds.findPar(connections[i][0])==ds.findPar(connections[i][1]))
                extra++;
         else   ds.unionSet(connections[i][0],connections[i][1]);
        }
     int cntConnected = 0;
     //too find number of components in the graph
     for(int i=0;i<n;i++){
        if(ds.parent[i]==i) cntConnected++;
     }
        int ans = cntConnected-1;
        if(extra >= ans ) return ans;
       return -1;
    }
}
public class Problem29 {
    public static void main(String[] args) {
      int   n = 6;
      int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
      Solution s = new Solution();
      System.out.println("Solution:"+s.makeConnected(n, connections));
    }
}
