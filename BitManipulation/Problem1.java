
//Problem:https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
import java.util.ArrayList;

class Solution {
    static boolean checkKthBitBruteForce(int n, int k) {
        // Your code here
        ArrayList<Integer> lst = new ArrayList<>();
        while (n != 0) {
            if (n % 2 == 1)
                lst.add(1);
            else
                lst.add(0);

            n = n / 2;
        }
        if (k >= lst.size())
            return false;
        return lst.get(k) == 1;
    }

    static boolean checkKthBitOptimal1(int n, int k) {
        // Your code here
        return (n & (1 << k)) != 0;
    }
     static boolean checkKthBitOptimal2(int n, int k) {
        // Your code here
     return (1  & (n>>k)) != 0;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 4;
        int k = 0;
        System.out.println("Brute Force:" + s.checkKthBitBruteForce(num, k));
        System.out.println("Optimal:" + s.checkKthBitOptimal1(num, k));
        System.out.println("Optimal:" + s.checkKthBitOptimal2(num, k));
    }
}
