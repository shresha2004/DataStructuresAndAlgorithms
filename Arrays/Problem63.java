//Problem:https://leetcode.com/problems/defuse-the-bomb/description/?envType=problem-list-v2&envId=sliding-window
import java.util.Arrays;
class Solution {
    public int[] decryptBruteForce(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if(k==0) return ans;
        for(int i=0;i<n;i++){
            int sum =0;
            if(k>0){
                for(int j=1;j<=k;j++){
                    sum += code[(i+j)%n];

                }
            }
            else{
                for(int j=1;j<= -k;j++){
                    sum += code[(i-j + n)%n];
                }
            }
            ans[i] = sum;
        }
        return ans;
    }
}
public class Problem63 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] code = {5,7,1,4};
        int k = 3;
        System.out.println("Brute Force:"+Arrays.toString(s.decryptBruteForce(code, k)));
    }
}
