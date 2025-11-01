//Problem:https://leetcode.com/problems/path-with-minimum-effort/description/
import java.util.*;
class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int m = heights.length;
        int n = heights[0].length;
        Integer[][] distance = new Integer[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                distance[i][j]=Integer.MAX_VALUE;
        pq.offer(new Pair(0, 0, 0));
        int[] dR = { -1, 0, 1, 0 };
        int[] dC = { 0, -1, 0, 1 };
        distance[0][0]=0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.row == m - 1 && cur.col == n - 1)
                    return cur.dist;
               
            for (int i = 0; i < 4; i++) {
                int row = dR[i] + cur.row;
                int col = dC[i] + cur.col;
                if (row >= 0 && col >= 0 && row < m && col < n) {
                    int curDist = Math.max(Math.abs(heights[row][col] - heights[cur.row][cur.col]),cur.dist);
                    if(curDist < distance[row][col]){
                    distance[row][col]=curDist;
                    pq.offer(new Pair(row, col, curDist));
                    }
                }
            }
        }
        return -1;
    }
}
public class Problem22 {
    public static void main(String[] args) {
      int[][]  heights = {{1,2,2},{3,8,2},{5,3,5}};
      Solution s = new Solution();
      System.out.println("Solution:"+s.minimumEffortPath(heights));
    }
}
