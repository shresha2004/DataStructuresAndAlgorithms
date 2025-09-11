//Problem:https://leetcode.com/problems/wildcard-matching/description/
class Solution {
    public boolean isMatchRecursive(String s, String p) {
       int sLen = s.length();
       int pLen = p.length();
    return checkMatchRecursive(s,p,sLen-1,pLen-1);
    }
    private boolean checkMatchRecursive(String s,String p, int sLen, int pLen){
        if(pLen < 0 && sLen < 0) return true;
        if(pLen < 0 && sLen>=0) return false;
        if(sLen < 0 && pLen>= 0){
            for(int k=0;k<=pLen;k++) 
                if(p.charAt(k) != '*')  return false;
        return true;
        }
        if(s.charAt(sLen)==p.charAt(pLen)||p.charAt(pLen)=='?') return checkMatchRecursive(s,p,sLen-1,pLen-1);
        else if(p.charAt(pLen)=='*') return checkMatchRecursive(s,p,sLen-1,pLen) || checkMatchRecursive(s,p,sLen,pLen-1);
        return false;
    }
     public boolean isMatchMemo(String s, String p) {
       int sLen = s.length();
       int pLen = p.length();
       Boolean[][] memo = new Boolean[sLen][pLen];
       for(int i=0;i<sLen;i++)
        for(int j=0;j<pLen;j++)
            memo[i][j]=null;
    return checkMatchMemo(s,p,sLen-1,pLen-1,memo);
    }
    private boolean checkMatchMemo(String s,String p, int sLen, int pLen,Boolean[][] memo){
        if(pLen < 0 && sLen < 0) return true;
        if(pLen < 0 && sLen>=0) return false;
        if(sLen < 0 && pLen>= 0){
            for(int k=0;k<=pLen;k++) 
                if(p.charAt(k) != '*')  return false;
        return true;
        }
        if(memo[sLen][pLen] != null) return memo[sLen][pLen];
        if(s.charAt(sLen)==p.charAt(pLen)||p.charAt(pLen)=='?') return memo[sLen][pLen]=checkMatchMemo(s,p,sLen-1,pLen-1,memo);
        else if(p.charAt(pLen)=='*') return memo[sLen][pLen]=checkMatchMemo(s,p,sLen-1,pLen,memo) || checkMatchMemo(s,p,sLen,pLen-1,memo);
        return memo[sLen][pLen]=false;
    }

     public boolean isMatchTabu(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        Boolean[][] tabu = new Boolean[sLen + 1][pLen + 1];
        tabu[0][0] = true;

        for (int i = 1; i <= sLen; i++)
            tabu[i][0] = false;

        for (int j = 1; j <= pLen; j++) {
            tabu[0][j] = tabu[0][j - 1] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    tabu[i][j] = tabu[i - 1][j - 1];

                else if (p.charAt(j - 1) == '*')
                    tabu[i][j] = tabu[i - 1][j] || tabu[i][j - 1];
                else
                    tabu[i][j] = false;
            }
        }
        return tabu[sLen][pLen];
    }

     public boolean isMatchSpo(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[] spo = new boolean[pLen + 1];
        spo[0] = true;

        

        for (int j = 1; j <= pLen; j++) {
            spo[j] = spo[j - 1] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= sLen; i++) {
            boolean[] temp = new boolean[pLen+1];
            temp[0]=false;
            for (int j = 1; j <= pLen; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    temp[j] = spo[j - 1];

                else if (p.charAt(j - 1) == '*')
                    temp[j] = spo[j] || temp[j - 1];
                else
                    temp[j] = false;
            }
            spo= temp;
        }
        return spo[pLen];
    }
}
public class Problem34 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss ="aabcdfaag",p ="aab*aa?";
        System.out.println("Recursive:"+s.isMatchRecursive(ss, p));
        System.out.println("Memoization:"+s.isMatchMemo(ss, p));
        System.out.println("Tabulation:"+s.isMatchTabu(ss, p));
        System.out.println("Space Optimization:"+s.isMatchSpo(ss, p));
    }
}
