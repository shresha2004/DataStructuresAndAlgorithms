//Problem:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
class Solution{
  public int maxProfitRecursive(int k, int[] prices) {
        return checkMaxProfitRecursive(prices,0,k,1);
    }
    private int checkMaxProfitRecursive(int[] prices,int index,int count,int buy){
        if(count == 0) return 0;
        if(index ==prices.length ) return 0;
        int profit  = 0;
        if(buy == 1){
            profit = Math.max(-prices[index]+checkMaxProfitRecursive(prices,index+1,count,0),0+checkMaxProfitRecursive(prices,index+1,count,1));
        }
        else{
            profit = Math.max(prices[index]+checkMaxProfitRecursive(prices,index+1,count-1,1),0+checkMaxProfitRecursive(prices,index+1,count,0));

        }
        return profit;
    }

     public int maxProfitMemo(int k, int[] prices) {
        int[][][] memo = new int[prices.length][2][k+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int l=0;l<=k;l++){
                memo[i][j][l]=-1;
                }
            }
        }
        return checkMaxProfitMemo(prices,0,k,1,memo);
    }
    private int checkMaxProfitMemo(int[] prices,int index,int count,int buy,int[][][] memo){
        if(count == 0) return 0;
        if(index ==prices.length ) return 0;
        if(memo[index][buy][count] != -1) return memo[index][buy][count];
        int profit  = 0;
        if(buy == 1){
            profit = Math.max(-prices[index]+checkMaxProfitMemo(prices,index+1,count,0,memo),0+checkMaxProfitMemo(prices,index+1,count,1,memo));
        }
        else{
            profit = Math.max(prices[index]+checkMaxProfitMemo(prices,index+1,count-1,1,memo),0+checkMaxProfitMemo(prices,index+1,count,0,memo));

        }
        return memo[index][buy][count]=profit;
    }

    public int maxProfitTabu(int k, int[] prices) {
        int[][][] tabu = new int[prices.length+1][2][k+1];
        for(int index=prices.length-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                for(int count=1;count<=k;count++){
                    int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[index]+tabu[index+1][0][count],0+tabu[index+1][1][count]);
                }
                else profit = Math.max(prices[index]+tabu[index+1][1][count-1],0+tabu[index+1][0][count]);
                tabu[index][buy][count]=profit;
                }
            }
        }
        return tabu[0][1][k];
    }
    

     public int maxProfitSpo(int k, int[] prices) {
        int[][] spo = new int[2][k+1];
        for(int index=prices.length-1;index>=0;index--){
            int[][] temp = new int[2][k+1];
            for(int buy=0;buy<2;buy++){
                for(int count=1;count<=k;count++){
                    int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[index]+spo[0][count],0+spo[1][count]);
                }
                else profit = Math.max(prices[index]+spo[1][count-1],0+spo[0][count]);
                temp[buy][count]=profit;
                }
            }
            spo = temp;
        }
        return spo[1][k];
    }
}
public class Problem38 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int k = 2;
        int []prices = {3,2,6,5,0,3};
        System.out.println("Recursive:"+s.maxProfitRecursive(k, prices));
        System.out.println("Memoization:"+s.maxProfitMemo(k, prices));
        System.out.println("Tabulation:"+s.maxProfitTabu(k, prices));
        System.out.println("Space Optimization:"+s.maxProfitSpo(k, prices));

    }
}
