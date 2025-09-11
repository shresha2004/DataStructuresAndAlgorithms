//Problem:https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
class Solution {
    public int maxProfit(int[] prices) {
        int buy =0;
        int maxProfit = 0;
        int sell =prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
             buy =prices[i];
             sell = Math.max(prices[i],sell);
            maxProfit=Math.max(sell-buy,maxProfit);
        }
        return maxProfit;
    }
}
public class Problem35 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution s = new Solution();
        System.out.println("Solution:"+s.maxProfit(prices));
    }
}
