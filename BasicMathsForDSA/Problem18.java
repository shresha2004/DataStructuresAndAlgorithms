//Problem:https://leetcode.com/problems/count-primes/description/
class Solution{
public int countPrimesBruteForce(int n) {
        if (n == 0 || n == 1)
            return 0;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (checkPrime(i))
                count++;
        }
        return count;

    }

    public int countPrimesBetter(int n) {
        if(n<=1) return 0;
        int[] isPrime = new int[n+1];
        int count = 0;
        for(int i=0;i<isPrime.length;i++) isPrime[i]=1;
        for(int i=2;i<n;i++){
            if(isPrime[i]==1){
                count++;
                for(int j=i*2;j<=n;j+=i) isPrime[j]=0;
            }
        }
        return count;
    }

     public int countPrimesOptimal(int n) {
        if(n<=2) return 0;
        boolean[] isPrime = new boolean[n];
        
        for(int i=0;i<isPrime.length;i++) isPrime[i]=true;
        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2;i*i<n;i++){
            if(isPrime[i]==true){
                for(int j=i*i;j<n;j+=i) isPrime[j]=false;
            }
        }
        int count = 0;
        for(boolean check : isPrime ){
            if(check) count++;
        }
        return count;
    }

    private boolean checkPrime(int num) {
        if (num <= 0)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
public class Problem18 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num =10 ;
        System.out.println("Brute Force:"+s.countPrimesBruteForce(num));
        System.out.println("Better:"+s.countPrimesBetter(num));
        System.out.println("Optimal:"+s.countPrimesBetter(num));
    }
}
