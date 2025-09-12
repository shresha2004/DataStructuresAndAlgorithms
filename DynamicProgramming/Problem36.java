//Problem:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
import java.util.Arrays;
class Solution{
 public int maxProfitRecursive(int[] prices) {
        int len = prices.length;
        return checkMaxProfitRecursive(prices,true,0);
    }
    private int checkMaxProfitRecursive(int[] prices,boolean buy,int index){
        if(index==prices.length) return 0;
        int maxProfit = 0;
        
        if(buy){
            maxProfit =Math.max( (-prices[index])+checkMaxProfitRecursive(prices,false,index+1),0+checkMaxProfitRecursive(prices,true,index+1));
        }
        else maxProfit = Math.max(prices[index]+checkMaxProfitRecursive(prices,true,index+1),checkMaxProfitRecursive(prices,false,index+1));
        return maxProfit;
    }
     public int maxProfitMemo(int[] prices) {
        int len = prices.length;
        int[][] memo = new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
        Arrays.fill(memo[i],-1);
        return checkMaxProfitMemo(prices,1,0,memo);
    }
    private int checkMaxProfitMemo(int[] prices,int buy,int index,int[][] memo){
        if(index==prices.length) return 0;
        int maxProfit = 0;
        if(memo[index][buy] != -1) return memo[index][buy];
        if(buy==1){
            maxProfit =Math.max( (-prices[index])+checkMaxProfitMemo(prices,0,index+1,memo),0+checkMaxProfitMemo(prices,1,index+1,memo));
        }
        else maxProfit = Math.max(prices[index]+checkMaxProfitMemo(prices,1,index+1,memo),checkMaxProfitMemo(prices,0,index+1,memo));
        return memo[index][buy]=maxProfit;
    }

     public int maxProfitTabu(int[] prices) {
        int len = prices.length;
        int[][] tabu = new int[prices.length+1][2];
        tabu[len][0]=tabu[len][1]=0;
        for(int index=len-1;index>=0;index--){
            
            for(int buy=0;buy<2;buy++){
                int maxProfit = 0;
                if(buy==1){
                    maxProfit =Math.max(-prices[index]+tabu[index+1][0],tabu[index+1][1]);
                }
                else maxProfit = Math.max(prices[index]+tabu[index+1][1],tabu[index+1][0]);
                tabu[index][buy]=maxProfit;
            }
        }
        return tabu[0][1];
    }

     public int maxProfitSpo(int[] prices) {
        int len = prices.length;
        int[] spo = new int[2];
        for(int index=len-1;index>=0;index--){
            int[] temp = new int[2];
            for(int buy=0;buy<2;buy++){
                int maxProfit = 0;
                if(buy==1){
                    maxProfit =Math.max(-prices[index]+spo[0],spo[1]);
                }
                else maxProfit = Math.max(prices[index]+spo[1],spo[0]);
                temp[buy]=maxProfit;
            }
            spo= temp;
        }
        return spo[1];
    }
}
public class Problem36 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Recurive:"+s.maxProfitRecursive(prices));
        System.out.println("Memoization:"+s.maxProfitMemo(prices));
        System.out.println("Tabulation:"+s.maxProfitTabu(prices));
        System.out.println("Space Optimization:"+s.maxProfitSpo(prices));
    }
}
