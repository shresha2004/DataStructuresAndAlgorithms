//Problem:https://leetcode.com/problems/word-ladder-ii/description/
import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        for (String word : wordList)
            set.add(word);
        int level = 0;
        ls.add(beginWord);
        q.offer(ls);
        ArrayList<String> levelEles = new ArrayList<>();
        levelEles.add(beginWord);
        while (!q.isEmpty()) {
            ArrayList<String> cur = q.poll();
            if (cur.size() > level) {
                level++;
                for (String ele : levelEles)
                    set.remove(ele);
            }
            String word = cur.get(cur.size() - 1);
            if (word.equals(endWord)) {
                if (ans.size() == 0)
                    ans.add(cur);
                else if (ans.get(0).size() == cur.size())
                    ans.add(cur);
            }
            for (int i = 0; i < word.length(); i++) {
                for(char a='a';a<='z';a++){
                    char[] arr = word.toCharArray();
                    arr[i]=a;
                    String rep = new String(arr);
                    if(set.contains(rep)){
                        cur.add(rep);
                        ArrayList<String> temp = new ArrayList<>(cur);
                        q.offer(temp);
                        levelEles.add(rep);
                        cur.remove(cur.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}


public class Problem9 {
    public static void main(String[] args) {
       String  beginWord = "hit", endWord = "cog";
       List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
       Solution s = new Solution();
       System.out.println("Solution:"+s.findLadders(beginWord, endWord, wordList));
    }
}
