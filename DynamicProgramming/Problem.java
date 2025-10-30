//Problem:https://leetcode.com/problems/coin-change/description/
import java.util.*;
class Solution{
  public int coinChangeRecursive(int[] coins, int amount) {
        int n = coins.length;
       int ans = findCoinsRecursive(coins,amount,n-1);
       return (ans >= 1e9)? -1 : ans;
    }
    private int findCoinsRecursive(int[] coins,int amount,int index){
        if(index == 0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return (int) 1e9;
        }
        int notTake = findCoinsRecursive(coins,amount,index-1);
        int Take = (int) 1e9;
        if(coins[index]<=amount )Take = 1+findCoinsRecursive(coins,amount-coins[index],index);
        return Math.min(Take,notTake);
    }

     public int coinChangeMemo(int[] coins, int amount) {
        int n = coins.length;
        int[][] memo = new int[n][amount+1];
      for(int i=0;i<n;i++)
        Arrays.fill(memo[i],-1);
       int ans = findCoinsMemo(coins,amount,n-1,memo);
       return (ans >= 1e9)? -1 : ans;
    }
    private int findCoinsMemo(int[] coins,int amount,int index,int[][] memo){
        if(index == 0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return (int) 1e9;
        }
        if(memo[index][amount] != -1) return memo[index][amount];
        int notTake = findCoinsMemo(coins,amount,index-1,memo);
        int Take = (int) 1e9;
        if(coins[index]<=amount )Take = 1+findCoinsMemo(coins,amount-coins[index],index,memo);
        return memo[index][amount]=Math.min(Take,notTake);
    }

     public int coinChangeTabu(int[] coins, int amount) {
        int n = coins.length;
        int[][] tabu = new int[n][amount + 1];
        //Determine the count that amount can be done using coin[0]
        for (int i = 0; i <= amount; i++)
            if (i % coins[0] == 0)
                tabu[0][i] =i / coins[0];
            else
                tabu[0][i] = (int) 1e9;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int notTake = tabu[i - 1][j];
                int Take = (int) 1e9;
                if (coins[i] <= j)
                    Take = 1 + tabu[i][j - coins[i]];
                tabu[i][j] = Math.min(Take, notTake);
            }
        }
        return (tabu[n - 1][amount] == (int) 1e9) ? -1 : tabu[n - 1][amount];
    }

    public int coinChangeSpo(int[] coins, int amount) {
        int n = coins.length;
        int[] spo = new int[amount + 1];
        //Determine the count that amount can be done using coin[0]
        for (int i = 0; i <= amount; i++)
            if (i % coins[0] == 0)
                spo[i] =i / coins[0];
            else
                spo[i] = (int) 1e9;

        for (int i = 1; i < n; i++) {
            int[] temp = new int[amount+1];
            for (int j = 0; j <= amount; j++) {
                int notTake = spo[j];
                int Take = (int) 1e9;
                if (coins[i] <= j)
                    Take = 1 + temp[j - coins[i]];
               temp[j] = Math.min(Take, notTake);
            }
            spo = temp;
        }
        return (spo[amount] == (int) 1e9) ? -1 : spo[amount];
    }
}
public class Problem {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println("Recursive:"+s.coinChangeRecursive(coins, amount));
        System.out.println("Memoization:"+s.coinChangeMemo(coins, amount));
        System.out.println("Tabulation:"+s.coinChangeTabu(coins, amount));
        System.out.println("Space Optimization:"+s.coinChangeSpo(coins, amount));

    }
}
