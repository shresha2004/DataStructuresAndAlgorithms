//Problem:https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=string
import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstringBruteForce(String s) {
        if (s.equals("") || s == null)
            return 0;
        int n = s.length();
        int maxLen = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String sub = s.substring(i, j + 1);

                int subLen = sub.length();
                int flag = 0;
                for (int k = 0; k < subLen - 1; k++) {
                    for (int l = k + 1; l < subLen; l++) {
                        if (sub.charAt(k) == sub.charAt(l)) {
                            flag = 1;
                            break;
                        }
                        if (flag == 1)
                            break;
                    }

                }
                if (flag == 0)
                    maxLen = Math.max(maxLen, subLen);

            }
        }

        return maxLen;
    }
    public int lengthOfLongestSubstringOptimal(String s) {
        if (s.equals("") || s == null)
            return 0;
        HashSet<Character> set= new HashSet<>();
       int maxLen = 0;
       int n = s.length();
       int left =0;
       int right = 0;
       while(right < n){
        if(!set.contains(s.charAt(right))){
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen,right - left +1);
            right++;
        }else{
            set.remove(s.charAt(left));
            left++;
        }
       }
        return maxLen;
    }
}
public class Problem16 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "abcabcbb";
        System.out.println("Brute Force:"+s.lengthOfLongestSubstringBruteForce(ss));
        System.out.println("Optimal:"+s.lengthOfLongestSubstringOptimal(ss));
    }
}
