
//Problem:https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1
import java.util.*;

class Solution {
    public String minWindowBruteForce(String s1, String s2) {
        // code here
        int len1 = s1.length();
        int len2 = s2.length();

        int check1 = 0;
        int check2 = 0;
        String ans = "";
        while (check1 < len1) {
            if (s1.charAt(check1) == s2.charAt(0)) {
                StringBuilder sb = new StringBuilder();
                sb.append(s1.charAt(check1));
                int a2 = 1;
                int a1 = check1 + 1;
                while (a2 < len2 && a1 < len1) {
                    if (s1.charAt(a1) == s2.charAt(a2))
                        a2++;
                    sb.append(s1.charAt(a1));
                    a1++;
                }
                int minLen = ans.length();
                if (a2 == len2)
                    if (minLen == 0 || minLen > sb.length())
                        ans = sb.toString();
            }
            check1++;
        }
        return ans;
    }

    public String minWindowOptimal(String s1, String s2) {
        // code here
        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0;

        String ans = "";
        int minLen = Integer.MAX_VALUE;
        while (i < len1) {
            int j = 0;
            while (i < len1) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == len2)
                        break;
                }
                i++;
            }

            if (j != len2)
                break;

            int end = i + 1;
            j = len2 - 1;
            while (i >= 0) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j--;
                    if (j < 0)
                        break;
                }
                i--;
            }
            int start = i;
            if (end - start < minLen) {
                minLen = end - start;

                ans = s1.substring(start, end);
            }
            i = start + 1;
        }

        return ans;
    }
}

public class Problem11 {
    public static void main(String[] args) {
        Solution s = new Solution();
     String s1 = "geeksforgeeks", s2 = "eksrg" ;
        System.out.println("Brute Force:"+s.minWindowBruteForce(s1, s2));
        System.out.println("Optimal:"+s.minWindowOptimal(s1, s2));
    }
}
