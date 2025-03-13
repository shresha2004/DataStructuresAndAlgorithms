//Problem:https://leetcode.com/problems/string-to-integer-atoi/description/
class Solution {
    public int myAtoiBruteForce(String s) {
     if(s.length()==0) return 0;
     s=s.trim();
          if(s.length()==0) return 0;
     int sign = 1,i=0;
     long result = 0;
     if(s.charAt(i)=='+' || s.charAt(i)=='-'){
        sign = (s.charAt(i)== '-')? -1 : 1; 
        i++;
     }

     while(i < s.length() && Character.isDigit(s.charAt(i))){
        result = result * 10 +(s.charAt(i)-'0');
        if(sign * result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign * result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        i++;
     }
 return (int) (sign * result);
    }
}
public class Problem10 {
 public static void main(String[] args) {
    Solution s = new Solution();
    String ss = "1337c0d3";
    System.out.println("Brute Force:"+s.myAtoiBruteForce(ss));
 }   
}
