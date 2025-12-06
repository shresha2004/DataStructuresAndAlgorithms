//Problem:https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
import java.util.*;
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        int aL = allowed.length();
        int arrLen = words.length;
        for(int i=0;i<aL;i++)
            set.add(allowed.charAt(i));
        
        int count = 0;
        for(int i=0;i<arrLen;i++){
            boolean flag = true;
            int len = words[i].length();
            for(int j=0;j<len;j++){
                if(!set.contains(words[i].charAt(j))){
                    flag = false;
                    break;
                }
            }
            if(flag == true) count++;
        }
        return count;
    }
}
public class Problem35 {
    public static void main(String[] args) {
      String[]  words = {"ad","bd","aaab","baa","badab"};
      String  allowed = "ab";
      Solution s = new Solution();
      System.out.println("Solution:"+s.countConsistentStrings(allowed, words));
    }
}
