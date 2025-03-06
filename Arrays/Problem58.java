//Problem:https://leetcode.com/problems/ugly-number-iii/description/
class Solution {
    public int nthUglyNumberBruteForce(int n, int a, int b, int c) {
        int count = 0;
        int i = 0;
        while(count <= n){
            i++;
            if(i%a == 0 || i%b ==0 || i%c ==0) count++;
            if(count ==n) return i;

        }
        return 0;
    }
}
public class Problem58 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3, a = 2, b = 3, c = 5;
        System.out.println("Brute Force:"+s.nthUglyNumberBruteForce(n, a, b, c));
    }
}
