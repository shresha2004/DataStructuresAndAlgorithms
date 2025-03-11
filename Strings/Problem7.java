//Problem:https://leetcode.com/problems/valid-anagram/description/
import java.util.Arrays;
class Solution {
    public boolean isAnagramBruteForce(String s, String t) {
        if(s.length()!= t.length()) return false;
         char[] charArrS = s.toCharArray();
         char[] charArrT = t.toCharArray();
         Arrays.sort(charArrS);
         Arrays.sort(charArrT);
         return Arrays.equals(charArrS,charArrT);
    }

    public boolean isAnagramOptimal(String s, String t) {
        if(s.length()!= t.length()) return false;
         int[] count = new int[26];
         for(int i=0;i<s.length();i++){
            count[(s.charAt(i)-'a')]++;
            count[(t.charAt(i)-'a')]--;
         }
         for(int val: count){
            if(val != 0) return false;
         }
         return true;
    }
}


public class Problem7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "anagram", t = "nagaram";
        System.out.println("Brute Force:"+s.isAnagramBruteForce(ss, t));
        System.out.println("Optimal:"+s.isAnagramOptimal(ss, t));
    }
}
