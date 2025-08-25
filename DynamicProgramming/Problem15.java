//Problem:https://leetcode.com/problems/coin-change-ii/description/
class Solution {
    public int changeRecursive(int amount, int[] coins) {
     return numberCount(amount,coins,0,0);
    }
    private int numberCount(int amount,int[] coins,int sum,int index){
        if(index == coins.length){
            if(sum == amount) return 1;
            else return 0;
        }
        int pick = 0;
        if(coins[index] <= (amount-sum))    pick = numberCount(amount,coins,sum+coins[index],index);
      
        int notPick = numberCount(amount,coins,sum,index+1);
        return pick+notPick;
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
