//Problem:https://leetcode.com/problems/largest-odd-number-in-string/description/
class Solution {

    public String largestOddNumberBruteForce(String num) {
        long number = Long.valueOf(num);
        while(number > 0){
            if(number%2 != 0) return Long.toString(number);
            number = number/10;
        }
        return "";
    }

        public String largestOddNumberOptimal(String num) {
          for(int i=num.length()-1;i>=0;i--){
            char check = num.charAt(i);
            if((check - '0')%2!=0) return num.substring(0,i+1);
          }
          return "";
        }
    
}

public class Problem3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String num ="5950546";
        System.out.println("Brute Force:"+s.largestOddNumberBruteForce(num));
        System.out.println("Optimal:"+s.largestOddNumberOptimal(num));
    }
}
