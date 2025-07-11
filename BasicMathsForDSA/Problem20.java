//Problem:https://www.geeksforgeeks.org/problems/prime-factorization-using-sieve/1
import java.util.List;
import java.util.ArrayList;
class Solution{
static List<Integer> findPrimeFactorsBruteForce(int N) {
        // code here
        List<Integer> ans = new ArrayList<>();
        int i=2;
        while(N != 1){
            if(N%i==0){
                
                while(N%i==0){
                    ans.add(i);
                    N/=i;
                }
            }
            i++;
        }
        return ans;
    }
    static List<Integer> findPrimeFactorsOptimal(int N) {
        // code here
        int limit = N+1;
        int[] spf = new int[limit];
        for(int i=1;i<limit;i++) spf[i]=i;
        for(int i=2;i*i<limit;i++){
            if(spf[i]==i){
                for(int j= i*i;j<limit;j+=i){
                    if(spf[j]==j) spf[j]=i;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(N != 1){
            ans.add(spf[N]);
            N/= spf[N];
        }
        return ans;
    }
}
public class Problem20 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 2000;
        System.out.println("Brute Force:"+s.findPrimeFactorsBruteForce(num));
        

        System.out.println("Optimal:"+s.findPrimeFactorsBruteForce(num)); 
    }
}
