//Problem:https://leetcode.com/problems/first-unique-character-in-a-string/description/?envType=problem-list-v2&envId=prshgx6i

import java.util.HashMap;

class Solution{
 public int firstUniqCharBruteForce(String s) {
       HashMap<Character,Integer> map = new HashMap<>();
       for(int i=0;i<s.length();i++){
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
       
       }
       for(int i=0;i<s.length();i++) {
        if(map.get(s.charAt(i)).equals(1)) return i;
       }
         return -1;
    }
}
public class Problem23 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss= "leetcode";
        System.out.println("Brute Force:"+s.firstUniqCharBruteForce(ss));
       // System.out.println("Optimal:"+s.);
    }
}
