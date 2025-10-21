//Problem:https://leetcode.com/problems/word-ladder/description/
import java.util.*;
class Pair{
    String word;
    int len;
    Pair(String word,int len){
        this.word = word;
        this.len = len;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        for(String word : wordList){
            set.add(word);
        }

        q.offer(new Pair(beginWord,1));
        if(set.contains(beginWord)) set.remove(beginWord);

        while(!q.isEmpty()){
           Pair node = q.poll();
           String word = node.word;
           int step = node.len;
            if(word.equals(endWord) == true) return step;
            for(int i=0;i<word.length();i++){
                
                for(char a= 'a'; a<='z';a++){
                    char[] wordArr =word.toCharArray();
                    wordArr[i]=a;
                    String str = new String(wordArr);
                    if(set.contains(str)){
                        set.remove(str);
                        q.offer(new Pair(str,step+1));
                    }
                }
            }

        }
        return 0;
    }
}
public class Problem8 {
    public static void main(String[] args) {
     String   beginWord = "hit", endWord = "cog";
     List<String>  wordList = new ArrayList<>();
     String[] words = {"hot","dot","dog","lot","cog"};
     for( String ele : words) wordList.add(ele);
     Solution sol = new Solution();
     System.out.println("Solution:"+sol.ladderLength(beginWord, endWord, wordList));
    }
}
