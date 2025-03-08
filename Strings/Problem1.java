//Problem:https://leetcode.com/problems/remove-outermost-parentheses/description/
import java.util.Stack;
class Solution {
    public String removeOuterParenthesesBruteForce(String s) {
      Stack<Character> stack = new Stack<>();
      StringBuilder result = new StringBuilder();
      for(char ch : s.toCharArray()){
        if(ch == '('){
            if(!stack.isEmpty()) result.append(ch);
            stack.push(ch);
        }
        else{
            stack.pop();
            if(!stack.isEmpty()) result.append(ch);
        }
      }
      return result.toString();
    }

    public String removeOuterParenthesesOptimal(String s) {
      StringBuilder result = new StringBuilder();
      int count =0;
      for(char ch : s.toCharArray()){
        if(ch == '('){
            if(count>0) result.append(ch);
            count++;
        }
        else{
            count--;
            if(count>0) result.append(ch);
        }
      }
      return result.toString();
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str  = "(()())(())(()(()))";
        System.out.println("Brute Force:"+s.removeOuterParenthesesBruteForce(str));
        System.out.println("Optimal:"+s.removeOuterParenthesesOptimal(str));
    }
}
