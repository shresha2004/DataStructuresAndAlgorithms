//Problem:https://www.geeksforgeeks.org/problems/chocolates-pickup/1
class Solution {
    public int solveRecursive(int n, int m, int grid[][]) {
        // Code here
        int j1=0;
        int j2=grid[0].length-1;
        return findMaxRecursive(0,j1,j2,grid,n,m);
    }
    
    private int findMaxRecursive(int i,int j1, int j2,int[][] grid,int n, int m){
        
        if(j1 < 0 || j2 < 0 || j2 >= m || j1 >= m ) return Integer.MIN_VALUE;
        
        
        if(i == n-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        } 
       
       
        int max = Integer.MIN_VALUE;
        for(int dj1 = -1;dj1<2;dj1++){
            for(int dj2 =-1;dj2<2;dj2++){
            int ans =0;
                if(j1 == j2) ans= grid[i][j1]+findMaxRecursive(i+1,j1+dj1,j2+dj2,grid,n,m);
                else ans = (grid[i][j1]+grid[i][j2])+findMaxRecursive(i+1,j1+dj1,j2+dj2,grid,n,m);
                max = Math.max(ans,max);
    }
        }
        return max;
        }
}
public class Problem14 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4, m = 3;
     int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println("Recursive:"+s.solveRecursive(n,m,grid));
    }
}
