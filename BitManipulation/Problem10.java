//Problem:https://leetcode.com/problems/divide-two-integers/description/
class Solution{
 public int divideBrutForce(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int sum = 0;
        int count = 0;
        while((sum + divisor )<= dividend){
            sum +=divisor;
            count++;
        }
        return (isNegative)? -count:count;
    }

    public int divideOptimal(int dividend, int divisor) {
         if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == divisor)
            return 1;
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int ans = 0;
        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1)))
                count++;
            ans += 1 << count;
            n -= (d << count);
        }
        
        return (isNegative) ? -ans : ans;
    }
}
public class Problem10 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int dividend = 10, divisor = 3;
        System.out.println("Brute Force:"+s.divideBrutForce(dividend, divisor));
        System.out.println("Optimal:"+s.divideOptimal(dividend, divisor));
    }
}

