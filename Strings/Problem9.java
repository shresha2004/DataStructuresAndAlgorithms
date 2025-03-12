//Problem:https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
import java.util.Stack;
class Solution {
    public int maxDepthBruteForce(String s) {
        Stack<Character> stck = new Stack<>();
        int maxDepth=0;
        for(char ch:s.toCharArray()){
         if(ch=='('){
             stck.push(ch);
             maxDepth=Math.max(maxDepth,stck.size());
         }
         else if(ch == ')') if(!stck.isEmpty()) stck.pop();
        }
        return maxDepth;
     }

    public int maxDepthOptimal(String s) {
       int count =0;
       int maxCount=0;
       for(int i=0;i<s.length();i++) {
        if(s.charAt(i)=='(') count++;
        if(s.charAt(i)==')'){
            maxCount = Math.max(maxCount,count);
            count--;
        }
       }
       return maxCount;
    }
    
}
public class Problem9 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "(1+(2*3)+((8)/4))+1";
        System.out.println("BruteForce:"+s.maxDepthBruteForce(ss));
        System.out.println("Optimal:"+s.maxDepthOptimal(ss));

    }
}
