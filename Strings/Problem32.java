//Problem:https://leetcode.com/problems/increasing-decreasing-string/description/
class Solution {
    public String sortString(String s) {
      int[] freq = new int[26]  ;
      for(int i=0;i<s.length();i++)
        freq[s.charAt(i)-'a']++;
    boolean reverse = true;
    StringBuilder sb = new StringBuilder();
    while(sb.length() != s.length()){
        if(reverse){
            for(int i=0;i<26;i++){
               if(freq[i]>0){
                 sb.append((char)(97+i));
                 freq[i]--;
               }
               reverse=false;
            }
        }
        else{
             for(int i=25;i>=0;i--){
               if(freq[i]>0){
                 sb.append((char)(97+i));
                 freq[i]--;
               }
               reverse=true;
        }

        }
    }
   return sb.toString();
    }
}
public class Problem32 {
    public static void main(String[] args) {
        String  s = "aaaabbbbcccc";
        Solution ss = new Solution();
        System.out.println("Answer:"+ss.sortString(s));
    }
}
