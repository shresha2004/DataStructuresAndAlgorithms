//Problem:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
class Solution{
 public int maxProfitRecursive(int[] prices, int fee) {
        return checkMaxProfitRecursive(prices,fee,0,1);
    }
    private int checkMaxProfitRecursive(int[] prices,int fee,int index,int buy){
        if(prices.length == index) return 0;
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[index]+checkMaxProfitRecursive(prices,fee,index+1,0),0+checkMaxProfitRecursive(prices,fee,index+1,1));
        
        }
        else{
            profit = Math.max(prices[index]-fee+checkMaxProfitRecursive(prices,fee,index+1,1),0+checkMaxProfitRecursive(prices,fee,index+1,0));

        }
        return profit;
    }


     public int maxProfitMemo(int[] prices, int fee) {
        int[][] memo = new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
            for(int j=0;j<2;j++)
                memo[i][j]=-1;
        return checkMaxProfitMemo(prices,fee,0,1,memo);
    }
    private int checkMaxProfitMemo(int[] prices,int fee,int index,int buy,int[][] memo){
        if(prices.length == index) return 0;
        if(memo[index][buy] != -1) return memo[index][buy];
        int profit = 0;
        if(buy==1){
            profit = Math.max(-prices[index]+checkMaxProfitMemo(prices,fee,index+1,0,memo),0+checkMaxProfitMemo(prices,fee,index+1,1,memo));
        
        }
        else{
            profit = Math.max(prices[index]-fee+checkMaxProfitMemo(prices,fee,index+1,1,memo),0+checkMaxProfitMemo(prices,fee,index+1,0,memo));

        }
        return memo[index][buy]=profit;
    }

     public int maxProfitTabu(int[] prices, int fee) {
        int[][] tabu = new int[prices.length+1][2];
        for(int index=prices.length-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                int profit = 0;
                if(buy ==1 ){
                    profit = Math.max(-prices[index]+tabu[index+1][0],0+tabu[index+1][1]);
                }
                else{
                    profit = Math.max(prices[index]-fee+tabu[index+1][1],0+tabu[index+1][0]);
                }
                tabu[index][buy]=profit;
            }
        }
        return tabu[0][1];
    }

    public int maxProfitSpo(int[] prices, int fee) {
        int[] spo = new int[2];
        for(int index=prices.length-1;index>=0;index--){
            int[] temp = new int[2];
            for(int buy=0;buy<2;buy++){
                int profit = 0;
                if(buy ==1 ){
                    profit = Math.max(-prices[index]+spo[0],0+spo[1]);
                }
                else{
                    profit = Math.max(prices[index]-fee+spo[1],0+spo[0]);
                }
                temp[buy]=profit;
            }
            spo= temp;
        }
        return spo[1];
    }
   
}
public class Problem40 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println("Recursive:"+s.maxProfitRecursive(prices, fee));
        System.out.println("Memoization:"+s.maxProfitMemo(prices, fee));
        System.out.println("Tabulation:"+s.maxProfitTabu(prices, fee));
        System.out.println("Memoization:"+s.maxProfitMemo(prices, fee));
    }
}
