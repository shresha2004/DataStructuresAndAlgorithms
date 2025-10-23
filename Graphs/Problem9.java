
//Problem:https://leetcode.com/problems/word-ladder-ii/description/
import java.util.*;

class Pair {
    int step;
    String word;

    Pair(String word, int step) {
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public List<List<String>> findLaddersBruteForce(String beginWord, String endWord, List<String> wordList) {
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
                for (char a = 'a'; a <= 'z'; a++) {
                    char[] arr = word.toCharArray();
                    arr[i] = a;
                    String rep = new String(arr);
                    if (set.contains(rep)) {
                        cur.add(rep);
                        ArrayList<String> temp = new ArrayList<>(cur);
                        q.offer(temp);
                        levelEles.add(rep);
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        }
        return ans;
    }

    public List<List<String>> findLaddersOptimal(String beginWord, String endWord, List<String> wordList) {
        // Step 1: Store the strings by which we can achive min path
        HashMap<String, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        for (String word : wordList)
            set.add(word);
        q.offer(new Pair(beginWord, 0));
        map.put(beginWord, 0);
        set.remove(beginWord);
        bfs(q, endWord, set, map);

        // Step 2:
        List<List<String>> ans = new ArrayList<>();
        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq, beginWord, map, ans);
        }
        return ans;
    }

    private void bfs(Queue<Pair> q, String endWord, HashSet<String> set, HashMap<String, Integer> map) {
        while (!q.isEmpty()) {
            Pair node = q.poll();
            if (node.word.equals(endWord)) {
                map.put(node.word, node.step);
            }
            for (int i = 0; i < node.word.length(); i++) {
                for (char a = 'a'; a <= 'z'; a++) {
                    char[] arr = node.word.toCharArray();
                    arr[i] = a;
                    String str = new String(arr);
                    if (set.contains(str)) {
                        q.offer(new Pair(str, node.step + 1));
                        map.put(str, node.step + 1);
                        set.remove(str);
                    }
                }
            }
        }
    }

    private void dfs(String word, List<String> seq, String beginWord, Map<String, Integer> map,
            List<List<String>> ans) {
        if (word.equals(beginWord)) {
            List<String> dup = new ArrayList<>(seq);
            reverse(dup);
            ans.add(dup);
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            for (char a = 'a'; a <= 'z'; a++) {
                char[] arr = word.toCharArray();
                arr[i] = a;
                String str = new String(arr);
                if (map.containsKey(str) && map.get(str) + 1 == map.get(word)) {
                    seq.add(str);
                    dfs(str, seq, beginWord, map, ans);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }

    private void reverse(List<String> ls) {
        int left = 0;
        int right = ls.size() - 1;
        while (left <= right) {
            String temp = ls.get(left);
            ls.set(left, ls.get(right));
            ls.set(right, temp);
            left++;
            right--;
        }
    }
}

public class Problem9 {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Solution s = new Solution();
        System.out.println("Brute Force Solution:" + s.findLaddersBruteForce(beginWord, endWord, wordList));
        System.out.println("Optimal Solution:"+s.findLaddersOptimal(beginWord, endWord, wordList));
    }
}
