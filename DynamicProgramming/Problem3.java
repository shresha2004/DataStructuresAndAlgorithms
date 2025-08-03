//Problem:https://www.geeksforgeeks.org/problems/geek-jump/1
class Solution {
    int minCostRecursive(int[] height) {
        // code here
        int n = height.length;
        return findCost(n - 1, height);

    }

    private int findCost(int ind, int[] height) {
        if (ind == 0)
            return 0;
        int left = findCost(ind - 1, height) + Math.abs(height[ind] - height[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1)
            right = findCost(ind - 2, height) + Math.abs(height[ind] - height[ind - 2]);
        return Math.min(left, right);
    }

    int minCostMemoization(int[] height) {
        // code here
        int n = height.length;
        int[] memo = new int[n];
        for (int i = 0; i < n; i++)
            memo[i] = -1;
        return findCostMemo(n - 1, height, memo);

    }

    private int findCostMemo(int ind, int[] height, int[] memo) {
        if (ind == 0)
            return 0;
        if (memo[ind] != -1)
            return memo[ind];
        int left = findCostMemo(ind - 1, height, memo) + Math.abs(height[ind] - height[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1)
            right = findCostMemo(ind - 2, height, memo) + Math.abs(height[ind] - height[ind - 2]);
        return memo[ind] = Math.min(left, right);
    }

    int minCostTabu(int[] height) {
        // code here
        int n = height.length;
        if (n == 0)
            return 0;
        int[] tab = new int[n];
        tab[0] = 0;

        for (int i = 1; i < n; i++) {
            int jump1 = tab[i - 1] + Math.abs(height[i] - height[i - 1]);
            int jump2 = Integer.MAX_VALUE;
            if (i > 1)
                jump2 = tab[i - 2] + Math.abs(height[i] - height[i - 2]);
            tab[i] = Math.min(jump1, jump2);
        }

        return tab[n - 1];

    }
     int minCostSpaceOpti(int[] height) {
        // code here
        int n = height.length;
        if(n==0) return 0;
        int prev1 =0;
        int prev2 =0;
       
      
        for(int i=1;i<n;i++){
            int jump1 =prev1+Math.abs(height[i]-height[i-1]);
            int jump2 = Integer.MAX_VALUE;
            if(i>1) jump2 = prev2+Math.abs(height[i]-height[i-2]);
                    int    sum =Math.min(jump1,jump2);

            prev2 = prev1;
            prev1 = sum;
        }
        
        return prev1;
        
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = { 20, 30, 40, 20 };
        System.out.println("Recursive:" + s.minCostRecursive(height));
        System.out.println("Memoization:" + s.minCostMemoization(height));
        System.out.println("Tabulation:" + s.minCostTabu(height));
        System.out.println("Space Optimization:" + s.minCostSpaceOpti(height));
    }

}
