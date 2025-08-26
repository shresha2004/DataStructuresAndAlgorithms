//Problem:https://leetcode.com/problems/coin-change-ii/description/
class Solution {
    public int changeRecursive(int amount, int[] coins) {
     return numberCountRecursive(amount,coins,0,0);
    }
    private int numberCountRecursive(int amount,int[] coins,int sum,int index){
        if(index == coins.length){
            if(sum == amount) return 1;
            else return 0;
        }
        int pick = 0;
        if(coins[index] <= (amount-sum))    pick = numberCountRecursive(amount,coins,sum+coins[index],index);
      
        int notPick = numberCountRecursive(amount,coins,sum,index+1);
        return pick+notPick;
    }

     public int changeMemo(int amount, int[] coins) {
     int[][] memo = new int[coins.length][amount+1];
     for(int i=0;i<coins.length;i++)
        for(int j=0;j<amount+1;j++)
            memo[i][j]=-1;
     return numberCountMemo(amount,coins,0,0,memo);
    }
    private int numberCountMemo(int amount,int[] coins,int sum,int index,int[][] memo){
        if(index == coins.length){
            if(sum == amount) return 1;
            else return 0;
        }
        if(memo[index][sum]!= -1) return memo[index][sum];
        int pick = 0;
        if(coins[index] <= (amount-sum))    pick = numberCountMemo(amount,coins,sum+coins[index],index,memo);
      
        int notPick = numberCountMemo(amount,coins,sum,index+1,memo);
        return memo[index][sum]=pick+notPick;
    }
}
public class Problem15 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int amount = 5;
       int[] coins = {1,2,5};
       System.out.println("Recursive:"+s.changeRecursive(amount, coins));
    }
}
