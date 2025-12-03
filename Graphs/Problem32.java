//Problem:https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

import java.util.Arrays;

class Solution {
    public int[][] floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] != 1e8 && dist[k][j] != 1e8)
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        return dist;
    }
}
public class Problem32 {
    public static void main(String[] args) {
        int matrix[][] = { { 0, 3, (int)1e8, 7 },
                         { 8, 0, 2, (int)1e8 },
                         { 5, (int)1e8, 0, 1 },
                         { 2, (int)1e8, (int)1e8, 0 } };
        Solution s = new Solution();
        System.out.println("Floydwarshell algorithm:"+Arrays.deepToString(s.floydWarshall(matrix)));
    }
}
