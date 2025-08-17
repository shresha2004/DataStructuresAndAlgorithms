//Problem:https://www.geeksforgeeks.org/problems/chocolates-pickup/1
class Solution {
    public int solveRecursive(int n, int m, int grid[][]) {
        // Code here
        int j1 = 0;
        int j2 = grid[0].length - 1;
        return findMaxRecursive(0, j1, j2, grid, n, m);
    }

    private int findMaxRecursive(int i, int j1, int j2, int[][] grid, int n, int m) {

        if (j1 < 0 || j2 < 0 || j2 >= m || j1 >= m)
            return Integer.MIN_VALUE;

        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 < 2; dj1++) {
            for (int dj2 = -1; dj2 < 2; dj2++) {
                int ans = 0;
                if (j1 == j2)
                    ans = grid[i][j1] + findMaxRecursive(i + 1, j1 + dj1, j2 + dj2, grid, n, m);
                else
                    ans = (grid[i][j1] + grid[i][j2]) + findMaxRecursive(i + 1, j1 + dj1, j2 + dj2, grid, n, m);
                max = Math.max(ans, max);
            }
        }
        return max;
    }

    public int solveMemo(int n, int m, int grid[][]) {
        // Code here
        int j1 = 0;
        int j2 = grid[0].length - 1;
        int[][][] memo = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++)
                    memo[i][j][k] = -1;
            }
        }
        return findMaxMemo(0, j1, j2, grid, n, m, memo);
    }

    private int findMaxMemo(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] memo) {

        if (j1 < 0 || j2 < 0 || j2 >= m || j1 >= m)
            return Integer.MIN_VALUE;

        if (memo[i][j1][j2] != -1)
            return memo[i][j1][j2];
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 < 2; dj1++) {
            for (int dj2 = -1; dj2 < 2; dj2++) {
                int ans = 0;
                if (j1 == j2)
                    ans = grid[i][j1] + findMaxMemo(i + 1, j1 + dj1, j2 + dj2, grid, n, m, memo);
                else
                    ans = (grid[i][j1] + grid[i][j2]) + findMaxMemo(i + 1, j1 + dj1, j2 + dj2, grid, n, m, memo);
                max = Math.max(ans, max);
            }
        }
        return memo[i][j1][j2] = max;
    }

    public int solveTabu(int n, int m, int grid[][]) {
        // Code here
        int[][][] tabu = new int[n][m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    tabu[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    tabu[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;

                    for (int dj1 = -1; dj1 < 2; dj1++) {
                        for (int dj2 = -1; dj2 < 2; dj2++) {
                            int ans = 0;
                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            if ((j1 + dj1 < 0 || j1 + dj1 >= m) || (j2 + dj2 < 0 || j2 + dj2 >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += tabu[i + 1][j1 + dj1][j2 + dj2];

                            max = Math.max(ans, max);

                        }
                    }
                    tabu[i][j1][j2] = max;
                }
            }
        }
        return tabu[0][0][m - 1];
    }

     public int solveSpo(int n, int m, int grid[][]) {
        // Code here
       int[][] spo = new int[m][m];
       int[][] cur = new int[m][m];
       for(int j1 = 0;j1<m;j1++){
           for(int j2 = 0;j2 < m;j2++){
               if(j1 == j2) spo[j1][j2] = grid[n-1][j1];
               else spo[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
           }
       }
       
       for(int i=n-2;i>=0;i--){
           for(int j1=0;j1<m;j1++){
               for(int j2 = 0;j2<m;j2++){
                int max = Integer.MIN_VALUE;
                
                
        for(int dj1 = -1;dj1<2;dj1++){
            for(int dj2 =-1;dj2<2;dj2++){
            int ans =0;
                if(j1 == j2) ans= grid[i][j1];
                else  ans = grid[i][j1]+grid[i][j2];
                
                  if ((j1 + dj1 < 0 || j1 + dj1 >= m) || (j2 + dj2 < 0 || j2 + dj2 >= m))
                ans += (int) Math.pow(-10, 9);
              else
                ans += spo[j1 + dj1][j2 + dj2];

             
              max = Math.max(ans, max);
                
    }
        }
        cur[j1][j2] = max;
        }
           }
            for (int a = 0; a < m; a++) {
        spo[a] = cur[a].clone();
      }
       }
       return spo[0][m-1];
        }
}

public class Problem14 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4, m = 3;
        int[][] grid = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
        System.out.println("Recursive:" + s.solveRecursive(n, m, grid));
        System.out.println("Memoization:" + s.solveMemo(n, m, grid));
        System.out.println("Tabulation:"+s.solveTabu(n,m,grid));
        System.out.println("Space Optimization:"+s.solveSpo(n, m, grid));
    }
}
