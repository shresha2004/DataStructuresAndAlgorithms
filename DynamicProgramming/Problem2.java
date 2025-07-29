//Problem:https://leetcode.com/problems/climbing-stairs/description/
class Solution {
    public int climbStairsNormalRecursion(int n) {
        if(n==0 || n==1) return 1;
        int left = climbStairsNormalRecursion(n-1);
        int right = climbStairsNormalRecursion(n-2);
      return left+right;
        }

         public int climbStairsMemoization(int n) {
        int[] memo = new int[n+1];
        for(int i=0;i<=n;i++) memo[i]=-1;
        return climbStairsMemo(n,memo);
        }

    private int climbStairsMemo(int n,int[] memo){
        if(n==0 || n==1) return 1;
        if(memo[n] != -1) return memo[n];
        int left = climbStairsMemo(n-1,memo);
        int right = climbStairsMemo(n-2,memo);
        return memo[n]=left+right;
    }
    public int climbStairsTabulation(int n) {
        if(n==0 || n==1) return 1;
        int[] tabu = new int[n+1];
        tabu[0]=1;
        tabu[1]=1;
       
        for(int i=2;i<=n;i++){
           tabu[i]=tabu[i-2]+tabu[i-1];
        }
return tabu[n];
        
    }
     public int climbStairsSpaceOptimization(int n) {
        if (n == 0 || n == 1)
            return 1;
        int prev2=1;
        int prev1=1;
        
       for(int i=2;i<=n;i++ ){
        int curr = prev2+prev1;
        prev2=prev1;
        prev1=curr;
       }
       //prev1=curr
    return prev1;
    }
}
public class Problem2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        System.out.println("Normal recursion:"+s.climbStairsNormalRecursion(n));
        System.out.println("Memoization method:"+s.climbStairsMemoization(n));
        System.out.println("Tabulation method:"+s.climbStairsTabulation(n));
        System.out.println("Space optimization:"+s.climbStairsSpaceOptimization(n));
    }
}
