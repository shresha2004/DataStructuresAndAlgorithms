//Problem:https://leetcode.com/problems/shortest-common-supersequence/description/
class Solution {
     public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] tabu = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    tabu[i][j] = 1 + tabu[i - 1][j - 1];
                else
                    tabu[i][j] = Math.max(tabu[i - 1][j], tabu[i][j - 1]);
            }
        }

        int i = len1;
        int j = len2;
        //sb.insert(0,str.charAt(i-1)) bcz to avoid reversing the string
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.insert(0,str1.charAt(i - 1));
                i--;
                j--;
            } else if (tabu[i - 1][j] > tabu[i][j - 1]) {
                sb.insert(0,str1.charAt(i - 1));
                i--;
            } else {
                sb.insert(0,str2.charAt(j - 1));
                j--;
            }

        }
        while (i > 0)
            sb.insert(0,str1.charAt(--i));
        while (j > 0)
            sb.insert(0,str2.charAt(--j));
      //  reverse(sb);

        return sb.toString();
    }

    private void reverse(StringBuilder sb) {
        int start = 0;
        int end = sb.length() - 1;
        while (start <= end) {
            char s = sb.charAt(start);
            char e = sb.charAt(end);
            sb.setCharAt(start++, e);
            sb.setCharAt(end--, s);
        }
    }
}

public class Problem31 {
    public static void main(String[] args) {
        Solution s = new Solution();

        String str1 = "abac", str2 = "cab";
        System.out.println("Solution:"+s.shortestCommonSupersequence(str1, str2));
    }
}
