//Problem:https://leetcode.com/problems/is-subsequence/description/?envType=problem-list-v2&envId=dynamic-programming
class Solution{
 public boolean isSubsequenceBruteForce(String s, String t) {
        boolean[] ans = new boolean[1];
        findSubsequence(s,t,ans,0,0);
        return ans[0];
    }
    private void findSubsequence(String s,String t,boolean[] ans,int it,int is){    if(is==s.length()) ans[0]=true;
        if(it == t.length()) return;
        if(is< s.length() && s.charAt(is)==t.charAt(it)) is+=1;
        findSubsequence(s,t,ans,it+1,is);
    }

       public boolean isSubsequenceOptimal(String s, String t) {
        int i=0;
        int j=0;
        while(i < s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)) i++;
            j++;
        }
        return i==s.length();
    }
}
public class Problem34 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "abc", t = "ahbgdc";
        System.out.println("Brute Force:"+s.isSubsequenceBruteForce(ss, t));
        System.out.println("Optimal:"+s.isSubsequenceOptimal(ss, t));
    }
}
