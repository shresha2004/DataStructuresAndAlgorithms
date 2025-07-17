import java.util.*;
class Solution {
    private int priority(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            
            case '^': return 3;
           
        }
         return -1;
    }
    public String infixToPrefix(String s) {
        // Your code goes here
        String ans ="";
        Stack<Character> st = new Stack<>();
        String rs = reverse(s);
        System.out.println(rs);
        
        for(int i=0;i<rs.length();i++){
            char ch = rs.charAt(i);
            if((ch>='A' && ch<='Z')||
                (ch>='a' && ch<='z')||
                (ch>='0' && ch<='9')) ans+=ch;
            else if(ch == '(') st.push(ch);
            else if(ch==')'){ while(st.peek()!='(') ans+=st.pop();
                st.pop();
            }
             else{
                while (!st.isEmpty() && priority(ch)<= priority(st.peek())) {
                    ans += st.pop();
                }
                st.push(ch);
             }   
            }
            
        
        while(!st.isEmpty()){
            if(st.peek()=='(') return "Invalid Exp";
            ans+=st.pop();
        }
        return reverse(ans);
    }

    private String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
              if(s.charAt(i)=='(' ) sb.append(')');
              else if(s.charAt(i) == ')') sb.append('(' );
              else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
public class Problem9 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String infix = "a+b*c";
       System.out.println( s.infixToPrefix(infix));
    }
}
