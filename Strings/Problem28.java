//Problem:https://leetcode.com/problems/reverse-string/description/?envType=problem-list-v2&envId=two-pointers
import java.util.*;
class Solution {
    public char[] reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start <= end){
            char temp = s[start];
            s[start++]=s[end];
            s[end--]=temp;

        }
        return s;
    }
}
public class Problem28 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Solution ss = new Solution();
        System.out.println("Solution:" + Arrays.toString(ss.reverseString(s)));
    }
}
