//Problem:https://leetcode.com/problems/shuffle-string/description/
class Solution {
    public String restoreString(String s, int[] indices) {
     char[] ans = new char[indices.length];
     for(int i=0;i<s.length();i++){
        ans[indices[i]]=s.charAt(i);
     }
     return new String(ans);
    }
}
public class Problem33 {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        Solution ss = new Solution();

        
        System.out.println("Answer:"+ss.restoreString(s, indices));
    }
}
