//Problem:https://leetcode.com/problems/powx-n/description/
class Solution{
 public double myPow(double x, int n) {
        long N = n;
       double ans = 1;
       if(N< 0){
        x=1/x;
        N=-N;
       }
        while(N>0){
            if(N%2 != 0){ ans *= x;
            N=N-1;}
            else {
                N= N/2;
                x *=x;
            }
        }
        return ans;
    }
}
public class Problem21 {
    public static void main(String[] args) {
        Solution s = new Solution();
    System.out.println("Optimal:"+s.myPow(2, 5));
    }
}
