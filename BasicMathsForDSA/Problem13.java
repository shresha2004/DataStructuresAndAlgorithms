//Problem:https://leetcode.com/problems/add-digits/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
  public int addDigitsBruteForce(int num) {

       while(num >= 10) {
        int digit1 = num%10;
        int digit2 = num/10;
        num = digit1+digit2;
       }
       return num;
    }
}
public class Problem13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 2147483647;
        System.out.println("Brute Force:"+s.addDigitsBruteForce(num));
       // System.out.println("Optimal:"+s.);
    }
}
