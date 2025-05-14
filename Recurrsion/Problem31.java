//Problem:https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
class Solution{
 boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        boolean[][] graph = new boolean[v][v];
        for(int[] edge : edges){
            graph[edge[0]][edge[1]]=true;
            graph[edge[1]][edge[0]]=true;
        }
        int[] marked = new int[v];
        return backtrack(v,edges,m,0,graph,marked);
        
    }
    private boolean backtrack(int v,int[][] edges,int m,int vertice,boolean[][] graph,int[] marked){
        if(vertice == v) return true;
        for(int c=1;c<=m;c++){
            if(canColor(v,edges,vertice,graph,marked,c)){
                marked[vertice]=c;
                if(backtrack(v,edges,m,vertice+1,graph,marked)) return true;
                marked[vertice]=0;
            }
            
        }
        return false;
    }
    
    private boolean canColor(int v,int[][] edges,int vertice,boolean[][] graph,int[] marked,int c){
        for(int i=0;i<v;i++){
            if(graph[vertice][i] && marked[i]==c) return false;
        }
        return true;
    }
}
public class Problem31 {
    public static void main(String[] args) {
       int V = 4;
       int[][] edges = {{0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};
       int m = 3;
        Solution s = new Solution();
        System.out.println("Recursive:"+s.graphColoring(V, edges, m));
    }
}
