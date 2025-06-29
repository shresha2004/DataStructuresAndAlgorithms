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
}
public class Problem20 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 2000;
        System.out.println("Brute Force:"+s.findPrimeFactorsBruteForce(num));

        
    }
}
