//Problem:https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
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
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 1 && grid[0].length==1) return (grid[0][0]==0)?1:-1;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> pq = new LinkedList<>();
        boolean[][] isVis = new boolean[grid.length][grid[0].length];
        if (grid[0][0] == 0) {
            isVis[0][0] = true;
            pq.offer(new Pair(0, 0, 1));
        } else {
            return -1;
        }
        while (!pq.isEmpty()) {
            Pair node = pq.poll();

            int[] dR = { -1, 0, 1, 0, -1, -1, 1, 1 };
            int[] dC = { 0, 1, 0, -1, -1, 1, 1, -1 };
            for (int i = 0; i < 8; i++) {
                int row = dR[i] + node.row;
                int col = dC[i] + node.col;
                if (row >= 0 && row < m && col >= 0 && col < n && !isVis[row][col] && grid[row][col] == 0) {
                    isVis[row][col] = true;
                    if (row == m - 1 && col == n - 1) {
                        return node.dist + 1;
                    }
                    pq.offer(new Pair(row, col, node.dist + 1));
                }
            }
        }
        return -1;
    }
}
public class Problem21 {
    public static void main(String[] args) {
        Solution sol = new Solution();
       int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
       System.out.println("Dijsktra's algo without priority queue:"+sol.shortestPathBinaryMatrix(grid));
    }
}
