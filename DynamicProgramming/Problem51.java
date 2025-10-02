
//Problem:https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
import java.util.*;

class Solution {
    static final int mod = 1000000007;

    static int countWaysRecursive(String s) {
        // code here

        return (int) f(s, 0, s.length() - 1, 1);
    }

    static long f(String s, int i, int j, int isTrue) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 1)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }
        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long lT = f(s, i, ind - 1, 1);
            long lF = f(s, i, ind - 1, 0);
            long rT = f(s, ind + 1, j, 1);
            long rF = f(s, ind + 1, j, 0);

            char op = s.charAt(ind);
            if (op == '&') {

                if (isTrue == 1)
                    ways = (ways + (lT * rT) % mod) % mod;
                else
                    ways = (ways + (lT * rF) % mod + (lF * rT) % mod + (lF * rF) % mod) % mod;
            } else if (op == '|') {
                if (isTrue == 1)
                    ways = (ways + (lT * rT) % mod + (lT * rF) % mod + (lF * rT) % mod) % mod;
                else
                    ways = (ways + (lF * rF) % mod) % mod;
            } else {
                if (isTrue == 1)
                    ways = (ways + (lT * rF) % mod + (lF * rT) % mod) % mod;
                else
                    ways = (ways + (lT * rT) % mod + (lF * rF) % mod) % mod;
            }

        }
        return ways;
    }

    static int countWaysMemo(String s) {
        // code here
        int n = s.length();
        long[][][] memo = new long[n][n][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], -1);
        return (int) f(s, 0, s.length() - 1, 1, memo);
    }

    static long f(String s, int i, int j, int isTrue, long[][][] memo) {
        if (i > j)
            return 0;
        if (memo[i][j][isTrue] != -1)
            return memo[i][j][isTrue];
        if (i == j) {
            if (isTrue == 1)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long lT = f(s, i, ind - 1, 1, memo);
            long lF = f(s, i, ind - 1, 0, memo);
            long rT = f(s, ind + 1, j, 1, memo);
            long rF = f(s, ind + 1, j, 0, memo);

            char op = s.charAt(ind);
            if (op == '&') {

                if (isTrue == 1)
                    ways = (ways + (lT * rT));
                else
                    ways = (ways + (lT * rF) + (lF * rT) + (lF * rF));
            } else if (op == '|') {
                if (isTrue == 1)
                    ways = (ways + (lT * rT) + (lT * rF) + (lF * rT));
                else
                    ways = (ways + (lF * rF));
            } else {
                if (isTrue == 1)
                    ways = (ways + (lT * rF) + (lF * rT));
                else
                    ways = (ways + (lT * rT) + (lF * rF));
            }

        }
        return memo[i][j][isTrue] = ways;
    }
}

public class Problem51 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "T|T&F^T";
        System.out.println("Recursive:"+s.countWaysRecursive(ss));
        System.out.println("Memo:"+s.countWaysMemo(ss));
    }
}
