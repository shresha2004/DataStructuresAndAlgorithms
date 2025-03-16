//Problem:https://leetcode.com/problems/add-strings/description/
import java.math.BigInteger;
class Solution {
    public String addStringsBruteForce(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        BigInteger sum = n1.add(n2);
        return sum.toString();
    }

    public String addStringsOptimal(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
 
        while(i>= 0 || j>=0 || carry != 0 ){
         int digit1 = (i>=0)? num1.charAt(i) - '0' : 0;
         int digit2 = (j>=0)? num2.charAt(j) - '0': 0;
        int  sum = digit1 + digit2 + carry;
         carry = sum/10;
         sb.append(sum % 10);
         j--;
         i--;
        }
  return sb.reverse().toString();
     }
}
public class Problem15 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String num1 = "11", num2 = "123";
        System.out.println("Brute Force:"+s.addStringsBruteForce(num1, num2));
        System.out.println("Optimal:"+s.addStringsOptimal(num1, num2));
    }
    
}
