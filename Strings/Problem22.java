//Problem:https://leetcode.com/problems/find-words-containing-character/description/?envType=daily-question&envId=2025-05-24

import java.util.ArrayList;
import java.util.List;

class Solution{
 public List<Integer> findWordsContainingBruteForce(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        int n = words.length;
        for(int i =0;i<n;i++){
            int strLen = words[i].length();
            for(int j=0;j<strLen;j++){
                if(x==words[i].charAt(j)){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
     public List<Integer> findWordsContainingOptimal(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        int n = words.length;
        for(int i =0;i<n;i++){
           if(words[i].indexOf(x) != -1) ans.add(i);
        }
        return ans;
    }
}
public class Problem22 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"leet","code"};
        char x = 'e';

        System.out.println("Brute Force:"+s.findWordsContainingBruteForce(words, x));
        System.out.println("Optimal:"+s.findWordsContainingOptimal(words, x));
    }
}
