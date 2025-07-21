//Problem:https://leetcode.com/problems/remove-k-digits/description/
import java.util.Stack;
class Solution {
    public String removeKdigits(String num, int k) {
        char[] numArr = num.toCharArray();
        int n = numArr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            int number = numArr[i]-'0';
            while(!st.isEmpty() && st.peek()>number && k>0){
                
              if(st.peek()!= 0)  k--;
                st.pop();
            }
           st.push(number);
        }
        while(k>0){ st.pop();
        k--;
        }
        if(st.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        for(int ele : st){          
            sb.append(ele);
        }
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.toString();
    }
}
public class Problem20 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String num = "1432219";
        int k = 3;
        System.out.println("Solution:"+s.removeKdigits(num, 3));
    }
}
