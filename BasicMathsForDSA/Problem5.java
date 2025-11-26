//Problem : https://www.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1
class Solution{
    public long sumOfDivisors(int N){
        long sum =0;
        for(int i=1;i<=N;i++){
            //N / i tells how many numbers from 1..N are multiples of i.
            //Multiply i by that count → total contribution of divisor i
            sum=sum+(N/i)*i;
        }
        return sum;
    } 
}
public class Problem5 {
    public static void main(String[] args) {
        Solution s=new Solution();
      System.out.println( s.sumOfDivisors(4)); 
    }
}
