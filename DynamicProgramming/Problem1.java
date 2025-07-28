 class Solution {
    public int fib(int n) {
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
}
public class Problem1{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Dynamic programing approach:"+s.fib(5));
    }
}
