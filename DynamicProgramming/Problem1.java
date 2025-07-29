 //Problem:https://leetcode.com/problems/fibonacci-number/description/
 class Solution {
    public int fibusingMemo(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=-1;
        }
       return fibUsingDP(n,dp);
    }

    public int fibUsingDP(int n, int[] dp){
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fibUsingDP(n-1,dp)+fibUsingDP(n-2,dp);
    }

     public int fibUsingTabul(int n) {
        if(n==0 || n==1) return n;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
      return dp[n];
    }
}
public class Problem1{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Usng memoization:"+s.fibusingMemo(5));
        System.out.println("Using tabulation:"+s.fibUsingTabul(5));
    }
}
