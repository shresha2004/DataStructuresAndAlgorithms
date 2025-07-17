//Problem:https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
import java.util.Stack;

class Solution {
    public static String infixToPostfix(String s) {
        // code here
        int i =0 ;
        String ans = "";
        Stack<Character> sk = new Stack<>();
        while(i<s.length()){
            if((s.charAt(i) >= 'A' && s.charAt(i)<= 'Z') ||
                (s.charAt(i)>= 'a' && s.charAt(i)<='z') ||
                (s.charAt(i)>='1' && s.charAt(i)<='9')){
                    ans+=s.charAt(i);
                }
                else if(s.charAt(i)=='(' ){ 
                    sk.push(s.charAt(i));
                }
                else if(s.charAt(i)==')'){ 
                    while(sk.peek() != '(') ans += sk.pop();
                    sk.pop();
                }
                    
                 else{   
                     while(!sk.isEmpty() && (priority(s.charAt(i)) <= priority(sk.peek()))){
                         ans += sk.pop();
                     }
                     sk.push(s.charAt(i));
                    }
                    i++;
     
        }
        while(!sk.isEmpty()){
            if(sk.peek() == '(') return "Invalid Expression";
            ans += sk.pop();
        }
        return ans;
    }
    
    private static int priority(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            
            case '*':
            case '/':
                return 2;
                
            case '^': 
                 return 3;
        }
        return -1;
    }
}


public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Postfix:"+s.infixToPostfix(infix));
    }
}
