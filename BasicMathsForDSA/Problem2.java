//Problem:https://leetcode.com/problems/reverse-integer/description/
class Solution {
    public int reverse(int x) {
        int reverse=0;
        
            
            while(Math.abs(x)>0){
               int digit=x%10;
               if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; 
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; 
            }
                reverse=(reverse*10)+digit;
                x=x/10;
            }
          
        
        return reverse;
    }
}
public class Problem2 {
 public static void main(String[] args) {
    Solution s=new Solution();
    System.out.println(s.reverse(45748));
 }
    
}
