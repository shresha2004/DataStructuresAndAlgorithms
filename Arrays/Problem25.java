//Problem:https://leetcode.com/problems/powx-n/description/?envType=problem-list-v2&envId=recursion
class Solution {
    double pow=1;
    double ans=1;
    public double myPowOptimal(double x, int n) {
        long N=n;
       if(N==0) return 1;
       if(N<0){
        x=1/x;
        N = -N;
       }
       double half=myPowOptimal(x, (int) (N/2));
       if(N%2==0){
        return half*half;
       }else
       {
       return half*half*x;
       }
    }
}
public class Problem25 {
     public static void main(String[] args) {
        Solution s=new Solution();
       
      System.out.println("Optimal Approach:"+s.myPowOptimal(2,10));
      System.out.println("Optimal Approach:"+s.myPowOptimal(2,-3));
     
     
    }
}
