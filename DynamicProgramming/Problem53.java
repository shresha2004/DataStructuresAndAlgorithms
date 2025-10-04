//Problem:https://leetcode.com/problems/partition-array-for-maximum-sum/description/
class Solution{
 public int maxSumAfterPartitioningRecursive(int[] arr, int k) {
        return findMaxSumRecursive(arr, k, 0);
    }

    private int findMaxSumRecursive(int[] arr, int k, int i) {

        if (i == arr.length)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        int len = 0;
        for (int ind = i; ind < Math.min(i+k,arr.length); ind++) {
            len++;
            cur = Math.max(cur,arr[ind]);
           int  curMaxSum = cur * (len) + findMaxSumRecursive(arr, k,ind+1);
            maxSum = Math.max(curMaxSum, maxSum);
        }
        return maxSum;
    }
     public int maxSumAfterPartitioningMemo(int[] arr, int k) {
        int[] memo = new int[arr.length];
        for(int i=0;i<arr.length;i++) memo[i]=-1;
        return findMaxSumMemo(arr, k, 0,memo);
    }

    private int findMaxSumMemo(int[] arr, int k, int i,int[] memo) {

        if (i == arr.length)
            return 0;
        if(memo[i] != -1) return memo[i];
        int maxSum = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        int len = 0;
        for (int ind = i; ind < Math.min(i+k,arr.length); ind++) {
            len++;
            cur = Math.max(cur,arr[ind]);
           int  curMaxSum = cur * (len) + findMaxSumMemo(arr, k,ind+1,memo);
            maxSum = Math.max(curMaxSum, maxSum);
        }
        return memo[i]=maxSum;
    }
     public int maxSumAfterPartitioningTabu(int[] arr, int k) {
        int n = arr.length;
        int[] tabu = new int[arr.length + 1];
        for (int i = n - 1; i >= 0; i--) {
            int maxSum = Integer.MIN_VALUE;
            int cur = Integer.MIN_VALUE;
            int len = 0;
            for (int ind = i; ind < Math.min(i + k, arr.length); ind++) {
                len++;
                cur = Math.max(cur, arr[ind]);
                int curMaxSum = cur * (len) +tabu[ind + 1];
                maxSum = Math.max(curMaxSum, maxSum);
            }
          tabu[i] = maxSum;
        }
        return tabu[0];
    }

  
}

public class Problem53 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println("Recursive:"+s.maxSumAfterPartitioningRecursive(arr, k));
        System.out.println("Memoization:"+s.maxSumAfterPartitioningMemo(arr, k));
        System.out.println("Tabulation:"+s.maxSumAfterPartitioningTabu(arr, k));
    }
}
