//Problem:https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
  public int subtractProductAndSum(int n) {
        int add =0;
        int mult = 1;
       while(n>0){
        int num = n%10;
        add += num;
        mult *= num;
        n /= 10; 
       }
      return mult - add;
    }
}
public class Problem16 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 234;
        System.out.println("Brute Force:"+s.subtractProductAndSum(num));
       // System.out.println("Optimal:"+s.);
    }
}
