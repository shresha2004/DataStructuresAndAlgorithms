//Problem:https://www.geeksforgeeks.org/problems/prefix-to-postfix-conversion/1
import java.util.*;
class Solution {
    static String preToPost(String pre_exp) {
        // code here
         Stack<String> st = new Stack<>();
        
        for(int i=pre_exp.length()-1;i>=0;i--){
           char ch = pre_exp.charAt(i);
           if((ch>='A' && ch<='Z') ||
                (ch>='a' && ch<='z') ||
                (ch >='0' && ch <= '9')) st.push(Character.toString(ch));
            else{
                String op1 = st.pop();
                String op2 = st.pop();
                st.push((op1+op2+Character.toString(ch)));
                
            }    
                
        }
        return st.peek();
    
    }
}
public class Problem13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String prefix ="*-A/BC-/AKL" ;
        System.out.println("Postfix:"+s.preToPost(prefix));
    }
}
