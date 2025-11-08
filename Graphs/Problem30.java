//Problem:https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
import java.util.*;
class DisjointSet{
    int[] parent;
    int[] rank;
    DisjointSet(int n){
        parent= new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public int findPar(int node){
        if(parent[node]==node)
            return node;
        return parent[node]=findPar(parent[node]);
    }

    public void unionByRank(int u,int v){
        int parU = findPar(u);
        int parV = findPar(v);
        if(parU == parV) return;
        if(rank[parU]<rank[parV]){
                parent[parU]=parV;
        }
        else if(rank[parV]<rank[parU]){
            parent[parV]=parU;
        }
        else{
            parent[parU]=parV;
            rank[parV]++;
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;


      //Find maxRow and maxCol to determine the dimension
      int maxRow=0;
      int maxCol = 0;
      for(int i=0;i<n;i++){
        maxRow = Math.max(maxRow,stones[i][0]);
        maxCol = Math.max(maxCol,stones[i][1]);
      }
      DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<stones.length;i++){
       ds.unionByRank(stones[i][0],stones[i][1]+maxRow+1);
       map.put(stones[i][0],1);
       map.put(stones[i][1]+maxRow+1,1);
      }
      int count=0;
      for(Map.Entry<Integer,Integer> e : map.entrySet()){
        if(ds.findPar(e.getKey())==e.getKey())
                count++;
      }
      return n-count;
    }
}
public class Problem30 {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
        Solution s = new Solution();
        System.out.println("Soultion:"+s.removeStones(stones));
    }
}
