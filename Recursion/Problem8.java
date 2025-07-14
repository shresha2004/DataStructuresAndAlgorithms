//Problem:https://leetcode.com/problems/fibonacci-number/description/
class Solution {
    int sum =0;
    public int fib(int n) {
        if( n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-2)+ fib(n-1);

    }
}
public class Problem8 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.fib(4));
    }
    
}
