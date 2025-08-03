//Problem:https://leetcode.com/problems/min-cost-climbing-stairs/description/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return minCost(cost,n);
    }
    private int minCost(int[] cost,int n){
        if(n== 0) return 0;
        if(n==1) return 0;
        int left = minCost(cost,n-1)+cost[n-1];
      int right = Integer.MAX_VALUE;
        right = minCost(cost,n-2)+cost[n-2];
        return Math.min(left,right);
    }
     public int minCostClimbingStairsMemo(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        for(int i=0;i<=n;i++) memo[i]=-1;
        return minCostMemo(cost,n,memo);
    }
    private int minCostMemo(int[] cost,int n,int[] memo){
        if(n== 0) return 0;
        if(n==1) return 0;
        if(memo[n] != -1) return memo[n];
        int left = minCostMemo(cost,n-1,memo)+cost[n-1];
      int right = Integer.MAX_VALUE;
        right = minCostMemo(cost,n-2,memo)+cost[n-2];
        return memo[n]=Math.min(left,right);
    }
     public int minCostClimbingStairsTabu(int[] cost) {
        int n = cost.length;
       int[] tabu = new int[n];
       tabu[0]=cost[0];
       tabu[1]=cost[1];
       for(int i=2;i<n;i++){
        tabu[i]=cost[i]+Math.min(tabu[i-1],tabu[i-2]);
       }
      return Math.min(tabu[n-1],tabu[n-2]);
    }
    public int minCostClimbingStairsSpaceOpti(int[] cost) {
        int n = cost.length;
      int prev2=cost[0];
       int prev1=cost[1];
       for(int i=2;i<n;i++){
        int curr=cost[i]+Math.min(prev2,prev1);
        prev2=prev1;
        prev1=curr;
       }
      return Math.min(prev2,prev1);
    }
}
public class Problem5 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] cost = {10,15,20};
        System.out.println("Recursive:"+s.minCostClimbingStairs(cost));
        System.out.println("Memoization:"+s.minCostClimbingStairsMemo(cost));
        System.out.println("Tabulation:"+s.minCostClimbingStairsTabu(cost));
    }
}
