//Problem:https://leetcode.com/problems/find-the-difference/description/
class Solution{
 public char findTheDifferenceOptimal(String s, String t) {
      char result = 0;
      for(char ele : s.toCharArray())
        result ^= ele;
      for(char ele : t.toCharArray())
        result ^= ele;

        return result;
    }
}
public class Problem5 {
    public static void main(String[] args) {
        Solution ss = new Solution();
       String  s = "abcd", t = "abcde";
        System.out.println("Optimal:"+ss.findTheDifferenceOptimal(s, t));
    }
}

