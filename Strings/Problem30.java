//Problem:https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=problem-list-v2&envId=two-pointers
import java.util.*;
class Solution {
    public String reverseVowels(String s) {
        String ls = s;
        char[] sArr = ls.toCharArray();
        int start = 0;
        int end = s.length()-1;
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        while(start <= end){
            while(start <= end && !set.contains(s.charAt(start))) start++;
            while( end >= start && !set.contains(s.charAt(end))) end--;
            if(start < end){
            char temp = sArr[start];
            sArr[start]=sArr[end];
            sArr[end]=temp;
            }
            start++;
            end--;
        }
        return new String(sArr);
    }
}
public class Problem30 {
 public static void main(String[] args) {
    String s = "IceCreAm";
    Solution ss = new Solution();
    System.out.println("Solution:"+ss.reverseVowels(s));
 }   
}
