//Problem:https://leetcode.com/problems/isomorphic-strings/description/
import java.util.HashMap;
class Solution {
    public boolean isIsomorphicBruteForce(String s, String t){
       HashMap<Character,Character> map = new HashMap<>();
       int sLen = s.length();

       for(int i=0;i<sLen;i++){
       char key = s.charAt(i);
        char value = t.charAt(i);
        if(map.containsKey(key)){
            if(map.get(key)!= value) return false;
        }
        else {
            if(map.containsValue(value)) return false;
            map.put(key,value);
        }
       
       }
       return true;
    }

    public boolean isIsomorphicOptimal(String s, String t){
        HashMap<Character,Character> map= new HashMap<>();
        HashMap<Character,Character> reverseMap = new HashMap<>();
        int sLen = s.length();
 
        for(int i=0;i<sLen;i++){
        char key = s.charAt(i);
         char value = t.charAt(i);
         if(map.containsKey(key)){
             if(map.get(key)!= value) return false;
         }
         else {
             if(reverseMap.containsKey(value)) return false;
             map.put(key,value);
             reverseMap.put(value,key);
         }
        
        }
        return true;
     }
}
public class Problem5 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String st = "egg", t = "add";
        System.out.println("Brute Force:"+s.isIsomorphicBruteForce(st, t));
        System.out.println("Optimal:"+s.isIsomorphicOptimal(st, t));
    }
}
