//Problem:https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
import java.util.*;
class Solution {
    public int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int[] hash = new int[256];
            for(int j=i;j<n;j++){

                if(hash[s.charAt(j)]==0){
                    maxLen = Math.max(maxLen,(j-i)+1);
                    hash[s.charAt(j)]=1;
                }
                else break;
            }

        }
         return maxLen;
}
public int lengthOfLongestSubstringOptimal1(String s) {
        if(s.equals("")) return 0;
       int n = s.length();
       int maxLen = Integer.MIN_VALUE;
      int left =0;
      int right = 0;
      HashSet<Character> set = new HashSet<>();
      
      while( right < n){
        if(!set.contains(s.charAt(right))){
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen,(right-left)+1);
            right++;
        }
        else{
             
            set.remove(s.charAt(left++));
      }
 
    }
         return maxLen;
}
public int lengthOfLongestSubstringOptimal2(String s) {
        int n = s.length();
        if(s.equals("")) return 0;
        if(n==1) return 1;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int right =0;
        int left =0;
        for(right =0;right<n;right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            maxLen = Math.max(maxLen,right-left+1);
           
        }
         return maxLen;
}

}

public class Problem1 {
    public static void main(String[] args) {
        String  s = "abcabcbb";
        Solution ss = new Solution();
        System.out.println("Brute Force:"+ss.lengthOfLongestSubstringBruteForce(s));
        System.out.println("Optimal 1:"+ss.lengthOfLongestSubstringOptimal1(s));
        System.out.println("Optimal 2:"+ss.lengthOfLongestSubstringOptimal2(s));
    }
}
