
//Problem:https://leetcode.com/problems/palindrome-partitioning-ii/description/
import java.util.*;

class Solution {
    public int minCutRecursive(String s) {
        int len = s.length();

        return findCut(s, 0, len) - 1;
    }

    private int findCut(String s, int i, int len) {
        if (i == s.length())
            return 0;
        StringBuilder sb = new StringBuilder();
        int minPartition = Integer.MAX_VALUE;
        for (int j = i; j < len; j++) {
            sb.append(s.charAt(j));
            if (checkPalindrome(sb.toString())) {
                int partition = 1 + findCut(s, j + 1, len);
                minPartition = Math.min(partition, minPartition);
            }
        }
        return minPartition;
    }

    public int minCutMemo(String s) {
        int len = s.length();
        int[] memo = new int[len];

        Arrays.fill(memo, -1);
        return findCut(s, 0, len, memo) - 1;
    }

    private int findCut(String s, int i, int len, int[] memo) {
        if (i == s.length())
            return 0;
        if (memo[i] != -1)
            return memo[i];
        StringBuilder sb = new StringBuilder();
        int minPartition = Integer.MAX_VALUE;
        for (int j = i; j < len; j++) {
            sb.append(s.charAt(j));
            if (checkPalindrome(sb.toString())) {
                int partition = 1 + findCut(s, j + 1, len, memo);
                minPartition = Math.min(partition, minPartition);
            }
        }
        return memo[i] = minPartition;
    }
     public int minCutTabu(String s) {
        int len = s.length();
        int[] tabu = new int[len + 1];

        for (int i = len-1; i>=0; i--) {
            int minPartition = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (checkPalindrome(s.substring(i,j+1))) {
                    int partition = 1 +tabu[j+1];
                    minPartition = Math.min(partition, minPartition);
                }
            }
            tabu[i]=minPartition;
        }

   
        return tabu[0]-1;
    }


    private boolean checkPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}

public class Problem52 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "aab";
        System.out.println("Recursive:" + s.minCutRecursive(ss));
        System.out.println("Memoization:"+s.minCutMemo(ss));
        System.out.println("Tabulation:"+s.minCutTabu(ss));
    }
}
