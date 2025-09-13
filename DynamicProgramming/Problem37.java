//Problem:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
class Solution {
    public int maxProfitRecursive(int[] prices) {
        int[][][] memo = new int[prices.length][2][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    memo[i][j][k] = -1;
            }
        }
        return checkProfitRecursive(prices, 1, 0, 0, memo);
    }

    private int checkProfitRecursive(int[] prices, int buy, int index, int count, int[][][] memo) {
        if (count == 2)
            return 0;
        if (index == prices.length)
            return 0;
        if (memo[index][buy][count] != -1)
            return memo[index][buy][count];
        int maxProfit = 0;
        if (buy == 1) {
            maxProfit = Math.max(-prices[index] + checkProfitRecursive(prices, 0, index + 1, count, memo),
                    0 + checkProfitRecursive(prices, 1, index + 1, count, memo));
        } else
            maxProfit = Math.max(prices[index] + checkProfitRecursive(prices, 1, index + 1, count + 1, memo),
                    0 + checkProfitRecursive(prices, 0, index + 1, count, memo));
        return memo[index][buy][count] = maxProfit;
    }

    public int maxProfitMemo(int[] prices) {
        int[][][] memo = new int[prices.length][2][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    memo[i][j][k] = -1;
            }
        }
        return checkProfitMemo(prices, 1, 0, 0, memo);
    }

    private int checkProfitMemo(int[] prices, int buy, int index, int count, int[][][] memo) {
        if (count == 2)
            return 0;
        if (index == prices.length)
            return 0;
        if (memo[index][buy][count] != -1)
            return memo[index][buy][count];
        int maxProfit = 0;
        if (buy == 1) {
            maxProfit = Math.max(-prices[index] + checkProfitMemo(prices, 0, index + 1, count, memo),
                    0 + checkProfitMemo(prices, 1, index + 1, count, memo));
        } else
            maxProfit = Math.max(prices[index] + checkProfitMemo(prices, 1, index + 1, count + 1, memo),
                    0 + checkProfitMemo(prices, 0, index + 1, count, memo));
        return memo[index][buy][count] = maxProfit;
    }

   

    public int maxProfitTabu(int[] prices) {
        int[][][] tabu = new int[prices.length + 1][2][3];

        for (int index = prices.length - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int count = 1; count <= 2; count++) {
                    int maxProfit = 0;
                    if (buy == 1)
                        maxProfit = Math.max(-prices[index] + tabu[index + 1][0][count], 0 + tabu[index + 1][1][count]);
                    else
                        maxProfit = Math.max(prices[index] + tabu[index + 1][1][count - 1],
                                0 + tabu[index + 1][0][count]);

                    tabu[index][buy][count] = maxProfit;
                }
            }
        }
        return tabu[0][1][2];
    }

    public int maxProfitSpo(int[] prices) {
        int[][] spo = new int[2][3];

        for (int index = prices.length - 1; index >= 0; index--) {
            int[][] temp = new int[2][3];
            for (int buy = 0; buy < 2; buy++) {
                for (int count = 1; count <= 2; count++) {
                    int maxProfit = 0;
                    if (buy == 1)
                        maxProfit = Math.max(-prices[index] + spo[0][count], 0 + spo[1][count]);
                    else
                        maxProfit = Math.max(prices[index] + spo[1][count - 1], 0 + spo[0][count]);

                    temp[buy][count] = maxProfit;
                }
            }
            spo = temp;
        }
        return spo[1][2];
    }
}

public class Problem37 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println("Recursive:"+s.maxProfitRecursive(prices));
        System.out.println("Memoization:"+s.maxProfitMemo(prices));
        System.out.println("Tabulation:"+s.maxProfitTabu(prices));
        System.out.println("Space Optimization:"+s.maxProfitSpo(prices));
    }
}
