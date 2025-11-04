import java.util.*;
class  Pair{
    int name;
    int wt;
    Pair(int name , int wt){
        this.name = name;
        this.wt = wt;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        //Step 1 : Convert to adj Arraylist
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
            
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        //Step 2 : Declare and initialize prerequisites
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.wt - b.wt);
        boolean[] isVis = new boolean[V];
        
        int sum =0;
        pq.offer(new Pair(0,0));//Node 0 came from -1 has wt 0
        
        while(!pq.isEmpty()){
            Pair curNode = pq.poll();
            if(isVis[curNode.name]) continue;
            isVis[curNode.name]=true;
            sum += curNode.wt;
            
            for(Pair neig : adj.get(curNode.name)){
                if(!isVis[neig.name])
                pq.offer(new Pair(neig.name,neig.wt));
            }
        }
        return sum;
    }
}

public class Problem27 {
    public static void main(String[] args) {
        int V = 3, E = 3;
        int[][] Edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        Solution s = new Solution();
        System.out.println("Prims Algorithm:"+s.spanningTree(V, Edges));
    }
}
