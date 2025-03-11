//Problem:https://leetcode.com/problems/rotate-string/description/
class Solution {
    public boolean rotateStringBruteForce(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String doubledString= s+s;
        System.out.println(doubledString);
        int length= goal.length();
        for(int i=0;i<length;i++){
            if(doubledString.substring(i,i+length).equals(goal)) return true;
        }
       return false; 
    }

    public boolean rotateStringOptimal(String s, String goal) {
        return ((s.length() == goal.length()) && ((s+s).contains(goal)));
       }
}
public class Problem6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "abcde", goal = "cdeab";
        System.out.println("Brute Force:"+s.rotateStringBruteForce(ss, goal));
        System.out.println("Optimal:"+s.rotateStringOptimal(ss, goal));
    }
}
