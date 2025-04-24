//Problem:https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/?envType=problem-list-v2&envId=prshgx6i
class Solution{
    public int mostWordsFoundBruteForce(String[] sentences) {
        int n = sentences.length;
        int maxWords = 0;
        for(int i=0;i<n;i++){
           String[] sen = sentences[i].split(" ");
            maxWords = Math.max(maxWords,sen.length);
        }
        return maxWords;
    }
}
public class Problem19 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println("Brute Force:"+s.mostWordsFoundBruteForce(sentences));
       // System.out.println("Optimal:"+s.);
    }
}
