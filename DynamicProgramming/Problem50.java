//Problem:https://leetcode.com/problems/burst-balloons/description/
import java.util.*;
class Solution{
 public int maxCoinsRecursive(int[] nums) {
        int len = nums.length;
        int[] eNums = new int[len+2];
        eNums[0]=1;
        int eLen = eNums.length;
        for(int i=1;i<=len;i++)
            eNums[i]=nums[i-1];
        eNums[eLen-1]=1;
        return maxCoinsRecursive(eNums,1,len);
    }
    private int maxCoinsRecursive(int[] eNums,int i,int j){
        if(i>j) return 0;
        int maxCoins =Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int coins = eNums[i-1]*eNums[ind]*eNums[j+1]+maxCoinsRecursive(eNums,i,ind-1)+maxCoinsRecursive(eNums,ind+1,j);
            maxCoins =Math.max(maxCoins,coins);
        }
        return maxCoins;
    }
     public int maxCoinsMemo(int[] nums) {
        int len = nums.length;
        int[] eNums = new int[len+2];
        eNums[0]=1;
        int eLen = eNums.length;
        for(int i=1;i<=len;i++)
            eNums[i]=nums[i-1];
        eNums[eLen-1]=1;
        int[][] memo = new int[eLen][eLen];
        for(int i=0;i<eLen;i++)
            Arrays.fill(memo[i],-1);
        return maxCoinsMemo(eNums,1,len,memo);
    }
    private int maxCoinsMemo(int[] eNums,int i,int j,int[][] memo){
        if(i>j) return 0;
        if(memo[i][j]!= -1) return memo[i][j];
        int maxCoins =Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int coins = eNums[i-1]*eNums[ind]*eNums[j+1]+maxCoinsMemo(eNums,i,ind-1,memo)+maxCoinsMemo(eNums,ind+1,j,memo);
            maxCoins =Math.max(maxCoins,coins);
        }
        return memo[i][j]=maxCoins;
    }
     public int maxCoinsTabu(int[] nums) {
        int len = nums.length;
        int[] eNums = new int[len + 2];
        eNums[0] = 1;
        int eLen = eNums.length;
        for (int i = 1; i <= len; i++)
            eNums[i] = nums[i - 1];
        eNums[eLen - 1] = 1;
        int[][] tabu = new int[eLen][eLen];
        for (int i = len; i > 0; i--) {
            for (int j = 1; j <= len; j++) {
                if (i > j)
                    continue;
                int maxCoins = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int coins = eNums[i - 1] * eNums[ind] * eNums[j + 1] + tabu[i][ ind - 1]  + tabu[ind + 1][j];
                          
                    maxCoins = Math.max(maxCoins, coins);
                }
                tabu[i][j]=maxCoins;
            }

        }
        return tabu[1][len];
    }

}
public class Problem50 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,1,5,8};
        System.out.println("Recursive:"+s.maxCoinsRecursive(nums));
        System.out.println("Memoization:"+s.maxCoinsMemo(nums));
        System.out.println("Tabulation:"+s.maxCoinsTabu(nums));

    }
}
