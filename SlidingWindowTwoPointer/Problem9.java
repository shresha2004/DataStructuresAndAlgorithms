//Problem:https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
import java.util.*;
class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
 
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLen = -1;
        while(right < n){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
               map.put(s.charAt(left),map.get(s.charAt(left))-1);
               if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }
           if(map.size()==k)  maxLen = Math.max(maxLen,(right-left)+1);
          
            right+=1;
        }
        
        return maxLen;
    }
}
class Problem9 {
    public static void main(String[] args) {
        String  s = "aabacbebebe";
        int k = 3;
        Solution ss = new Solution();
        System.out.println("Solution:"+ss.longestKSubstr(s, k));
    }
}