//Problem:https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1
class Solution {
    public static int findXORBruteForce(int l, int r) {
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans ^= i;
            System.out.println(ans + "\n");
        }
        return ans;
    }

    public static int findXOROptimal(int l, int r) {
        return XORAns(l - 1) ^ XORAns(r);
    }

    private static int XORAns(int n) {
        if ((n % 4) == 1)
            return 1;
        else if (n % 4 == 2)
            return n + 1;
        else if (n % 4 == 3)
            return 0;
        else
            return n;

    }
}

public class Problem12 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int L = 1, R = 10;
        System.out.println("Brute Force:" + s.findXORBruteForce(L, R));
        System.out.println("Optimal:" + s.findXOROptimal(L, R));
    }
}
