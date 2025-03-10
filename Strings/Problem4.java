//problem:https://leetcode.com/problems/longest-common-prefix/description/

class Solution {
    public String longestCommonPrefixBruteForce(String[] strs) {
        int n = strs.length;
        if(n==0) return "";
        String prefix = strs[0];
        for(int i=0;i<n;i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefixOptimal(String[] strs) {
        int n  = strs.length;
        if(n==0) return "";
        for(int i=0;i<strs[0].length();i++){
         char check = strs[0].charAt(i);
         for(int j=1;j<strs.length;j++){
             if(i>=strs[j].length() || strs[j].charAt(i) != check ){
                 return strs[j].substring(0,i);
             }
         }
 
        }
        return strs[0];
     }
}
public class Problem4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"flower","flow","flight"};
        System.out.println("Brute Force:"+s.longestCommonPrefixBruteForce(strs));
        System.out.println("Optimal:"+s.longestCommonPrefixOptimal(strs));
    }
}
