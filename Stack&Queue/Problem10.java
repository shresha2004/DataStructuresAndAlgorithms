//Problem:https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1
import java.util.Stack;

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if((ch>='A' && ch<='Z') ||
                (ch>='a' && ch<='z')||
                (ch>='0' && ch <='9')) st.push(Character.toString(ch));
            else{
                String op2 = st.pop();
                String op1 = st.pop();
                String ele = "("+op1+Character.toString(ch)+op2+")";
                st.push(ele);
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            
            ans += st.pop();
            
        }
        return ans;
    }
}



public class Problem10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String postfix = "AB-DE+F*/";
        System.out.println("Solution:"+s.postToInfix(postfix));
    }
}
