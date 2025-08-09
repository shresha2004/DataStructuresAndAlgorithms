class Solution {
    public int uniquePathsRecursive(int m, int n) {
        return countPathsRecursive(m-1,n-1);
    }
    private int countPathsRecursive(int row,int column){
        if(row == 0 && column == 0) return 1;
        if(row<0 || column <0) return 0;
        int left = countPathsRecursive(row-1,column);
        int right = countPathsRecursive(row,column-1);
        return left + right;
    }

      public int uniquePathsMemoization(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
        }
        return countPathsMemoization(m-1,n-1,memo);
    }
    private int countPathsMemoization(int row,int column,int[][] memo){
         if(row<0 || column <0) return 0;
         if(memo[row][column] != -1) return memo[row][column];
        if(row == 0 && column == 0) return 1;
        int left = countPathsMemoization(row-1,column,memo);
        int right = countPathsMemoization(row,column-1,memo);
        return memo[row][column]=left + right;
    }
}
public class Problem9 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 3;
        int n= 2;
        System.out.println("Recursive:"+s.uniquePathsRecursive(m, n));
        System.out.println("Memoization:"+s.uniquePathsMemoization(m, n));
    }

  
}
