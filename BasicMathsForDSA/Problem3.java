//Problem:Palindrome(https://leetcode.com/problems/palindrome-number/description/)
class Solution {
    public boolean isPalindrome(int x) {
        boolean palindrome=false;
        int number =x;
        int reverse=0;
        while(number>0 && number < Integer.MAX_VALUE){
            int digit = number%10;
            reverse=(reverse*10)+digit;
            number=number/10;
        }
        if (reverse == x){
            palindrome=true;
        }
        return palindrome;
    }
}
public class Problem3 {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.isPalindrome(4443));
    }
    
}
