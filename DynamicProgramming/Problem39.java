//Problem:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
import java.util.*;
class Solution{
public int maxProfitMyRecursive(int[] prices) {
        return checkProfitMyRecursive(prices,0,0,1);
    }
    private int checkProfitMyRecursive(int[] prices,int isCooled,int index,int buy){
        if(index == prices.length) return 0;
        if(isCooled == 1) return checkProfitMyRecursive(prices,0,index+1,buy);
        int profit = 0;
        if(buy ==1) profit = Math.max(-prices[index]+checkProfitMyRecursive(prices,0,index+1,0),0+checkProfitMyRecursive(prices,0,index+1,1));
        else profit = Math.max(prices[index]+checkProfitMyRecursive(prices,1,index+1,1),0+checkProfitMyRecursive(prices,0,index+1,0));
        return profit;
    }

    public int maxProfitMyMemo(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
            Arrays.fill(memo[i],-1);
        return checkProfitMyMemo(prices,0,0,1,memo);
    }
    private int checkProfitMyMemo(int[] prices,int isCooled,int index,int buy,int[][] memo){
        if(index == prices.length) return 0;
        if(isCooled == 1) return checkProfitMyMemo(prices,0,index+1,buy,memo);
        if(memo[index][buy] != -1) return memo[index][buy];
        int profit = 0;
        if(buy ==1) profit = Math.max(-prices[index]+checkProfitMyMemo(prices,0,index+1,0,memo),0+checkProfitMyMemo(prices,0,index+1,1,memo));
        else profit = Math.max(prices[index]+checkProfitMyMemo(prices,1,index+1,1,memo),0+checkProfitMyMemo(prices,0,index+1,0,memo));
        return memo[index][buy]=profit;
    }

     public int maxProfitRecursive(int[] prices) {
        return checkProfitRecursive(prices,0,1);
    }
    private int checkProfitRecursive(int[] prices,int index,int buy){
        if(index >= prices.length) return 0;
        int profit = 0;
        if(buy ==1) profit = Math.max(-prices[index]+checkProfitRecursive(prices,index+1,0),0+checkProfitRecursive(prices,index+1,1));
        else profit = Math.max(prices[index]+checkProfitRecursive(prices,index+2,1),0+checkProfitRecursive(prices,index+1,0));
        return profit;
    }

     public int maxProfitMemo(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
            Arrays.fill(memo[i],-1);
        return checkProfitMemo(prices,0,1,memo);
    }
    private int checkProfitMemo(int[] prices,int index,int buy,int[][] memo){
        if(index >= prices.length) return 0;
         if(memo[index][buy] != -1) return memo[index][buy];
        int profit = 0;
        if(buy ==1) profit = Math.max(-prices[index]+checkProfitMemo(prices,index+1,0,memo),0+checkProfitMemo(prices,index+1,1,memo));
        else profit = Math.max(prices[index]+checkProfitMemo(prices,index+2,1,memo),0+checkProfitMemo(prices,index+1,0,memo));
        return memo[index][buy]=profit;
    }

     public int maxProfitTabu(int[] prices) {
        int[][] tabu = new int[prices.length + 2][2];
        for (int index = prices.length - 1; index >= 0; index--) {

                    tabu[index][1] = Math.max(-prices[index]+tabu[index+1][0],0+tabu[index+1][1]);
                  
                       tabu[index][0] = Math.max(prices[index]+tabu[index+2][1],0+tabu[index+1][0]);
                    
                }

            

    return tabu[0][1];

}
 public int maxProfitOpti(int[] prices) {
        int[][] tabu = new int[prices.length + 2][2];
        for (int index = prices.length - 1; index >= 0; index--) {

                    tabu[index][1] = Math.max(-prices[index]+tabu[index+1][0],0+tabu[index+1][1]);
                  
                       tabu[index][0] = Math.max(prices[index]+tabu[index+2][1],0+tabu[index+1][0]);
                    
                }

            

    return tabu[0][1];
}
}
public class Problem39 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] prices = {1,2,3,0,2};
        System.out.println("My Recursive"+s.maxProfitMyRecursive(prices));
        System.out.println("My Memoization:"+s.maxProfitMyMemo(prices));
        System.out.println("Recurive:"+s.maxProfitRecursive(prices));
        System.out.println("Memoization:"+s.maxProfitMemo(prices));
        System.out.println("Tabulation:"+s.maxProfitTabu(prices));
        System.out.println("Time Optimized:"+s.maxProfitOpti(prices));
    }
}
