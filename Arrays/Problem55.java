//Problem:https://leetcode.com/problems/valid-parentheses/description/
import java.util.Stack;
class Solution {
    public boolean isValidBruteForce(String s) {
        
       while(s.contains("()") || s.contains("{}") || s.contains("[]") ){
            s = s.replace("()","")
                  .replace("{}","")
                    .replace("[]","");
                
       }
       if(s.isEmpty()) return true;
       return false;
        
    }
    public boolean isValidOptimal(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch=='{'||ch=='[') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((ch ==')' && top != '(') || 
                (ch == '}' && top != '{' ) || 
                (ch == ']' && top != '[') ) 
                return false;
            }
        }
        return stack.isEmpty();
        
    }
}
public class Problem55 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Brute Force:"+s.isValidBruteForce("(){}[]"));
        System.out.println("Optimal:"+s.isValidOptimal("(){}[]"));
    }
}
