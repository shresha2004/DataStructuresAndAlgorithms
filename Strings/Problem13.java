//Problem:https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/
import java.util.HashMap;
class Solution {
    public int beautySumBruteForce(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                
                for (int val : map.values()) {
                    max = Math.max(max, val);
                    min = Math.min(min, val);
                }
                
                sum += (max - min);
            }
        }
        return sum;
    }
}
public class Problem13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "aabcb";
        System.out.println("Brute Force:"+s.beautySumBruteForce(ss));
    }
}
