//Problem:https://leetcode.com/problems/add-strings/description/
import java.math.BigInteger;
class Solution {
    public String addStrings(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        BigInteger sum = n1.add(n2);
        return sum.toString();
    }
}
public class Problem15 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String num1 = "11", num2 = "123";
        System.out.println("Brute Force:"+s.addStrings(num1, num2));
    }
}
