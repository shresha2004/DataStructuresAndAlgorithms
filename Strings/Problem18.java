//Problem:https://leetcode.com/problems/word-pattern/description/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        for(int i=0;i<pattern.length();i++){
            for(int j=i+1;j<pattern.length();j++){
                if(pattern.charAt(i)==pattern.charAt(j)){
                    if(!words[i].equals(words[j])) return false;
                }
                if(pattern.charAt(i)!=pattern.charAt(j)){
                    if(words[i].equals(words[j])) return false;
                }
            }
        }
        return true;
    }
}
public class Problem18 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String pattern = "abba";
        String ss = "dog cat cat dog";
        System.out.println("Brute Force:"+s.wordPattern(pattern, ss));

    }
}
