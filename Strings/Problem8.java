//Problem:https://leetcode.com/problems/sort-characters-by-frequency/description/
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
class Solution {
    public String frequencySortBruteForce(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Character> charList = new ArrayList<>(map.keySet());

       Collections.sort(charList,(a,b)->map.get(b)-map.get(a));
      StringBuilder sb = new StringBuilder();
      for(char c : charList){
        int freq = map.get(c);
        while(freq-- > 0)
            sb.append(c);
      }
      return sb.toString();
    }

    public String frequencySortOptimal(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
       List<Character>[] buckets = new List[s.length()+1];
       for(char c : map.keySet()){
         int freq = map.get(c);
         if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
         buckets[freq].add(c);
       }
       StringBuilder sb = new StringBuilder();
       for(int i=buckets.length-1;i>=0;i--){
        if(buckets[i] != null){
        for(char ch:buckets[i]){
            sb.append(String.valueOf(ch).repeat(i));
        }
        }
    }

    return sb.toString();
    }
}
public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "tree";
        System.out.println("Brute Force:"+s.frequencySortBruteForce(ss));
        System.out.println("Optimal:"+s.frequencySortOptimal(ss));
    }
}
