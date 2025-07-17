//Problem:https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1
import java.util.Stack;

class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=0;i<post_exp.length();i++){
           char ch = post_exp.charAt(i);
           if((ch>='A' && ch<='Z') ||
                (ch>='a' && ch<='z') ||
                (ch >='0' && ch <= '9')) st.push(Character.toString(ch));
            else{
                String op2 = st.pop();
                String op1 = st.pop();
                st.push((Character.toString(ch)+op1+op2));
                
            }    
                
        }
        return st.peek();
    }
}


public class Problem12 {
  public static void main(String[] args) {
    Solution s = new Solution();
    String postfix = "ABC/-AK/L-*";
    System.out.println("Prefix:"+s.postToPre(postfix));
  }   
}
