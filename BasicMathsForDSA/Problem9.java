//Problem:https://leetcode.com/problems/count-good-numbers/description/
class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n){
     long evenCount = (n+1)/2;
     long oddCount = n/2;
     long evenWays = power(5,evenCount);
     long oddWays = power(4,oddCount);
     return (int) ((evenWays * oddWays)%MOD);
    }
    public long power(long base,long exp){
        long res = 1;
         base = base % MOD;
        while(exp > 0){
            if(exp %2 == 1) res = (res*base)%MOD;
            base = (base*base) % MOD;
            exp/=2;
        }
        return res;
    }
}
public class Problem9 {
    public static void main(String[] args) {
        Solution s= new Solution();

        System.out.println("Answer:"+s.countGoodNumbers(4));
    }
}
