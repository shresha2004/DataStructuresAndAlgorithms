//Problem:https://leetcode.com/problems/longest-string-chain/description/
import java.util.*;
class Solution{
static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    public int longestStrChain(String[] words) {
        int n = words.length;
       Arrays.sort(words,comp);
        int[] lenArr = new int[n];
        Arrays.fill(lenArr, 1);
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {

                if (compareString(words[prev], words[index]) && (1 + lenArr[prev] > lenArr[index])) {
                    lenArr[index] = 1 + lenArr[prev];
                }
            }
        }
        int maxLen = 0;
        for (int len : lenArr) {
            if (len > maxLen)
               maxLen = len;
        }
        return maxLen;
    }
    private boolean compareString(String shorter, String longer){
        if(longer.length() != shorter.length()+1){
            return false;
        }
        int first = 0;
        int second = 0;
        while(first < shorter.length() && second < longer.length()){
            if(shorter.charAt(first) == longer.charAt(second))
                first++;
            second++;
        }
        return first == shorter.length();
    }
}
public class Problem45 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println("Solution:"+s.longestStrChain(words));

    }
}
