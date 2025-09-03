//Problem:https://leetcode.com/problems/longest-palindromic-subsequence/description/
class Solution{
public int longestPalindromeSubseqRecursive(String s) {
      StringBuilder sb = new StringBuilder();
      for(int i=s.length()-1;i>=0;i--)
            sb.append(s.charAt(i));
        return checkLongRecursive(s,sb.toString(),0,0);
    }
    private int checkLongRecursive(String s1, String s2,int ind1, int ind2) {
        if(s1.length()==ind1 || s2.length()==ind2) return 0;
        if(s1.charAt(ind1)==s2.charAt(ind2)) return 1+checkLongRecursive(s1,s2,ind1+1,ind2+1);
        else  return Math.max(checkLongRecursive(s1,s2,ind1+1,ind2),checkLongRecursive(s1,s2,ind1,ind2+1));
    }

     public int longestPalindromeSubseqMemo(String s) {
      StringBuilder sb = new StringBuilder();
      int len = s.length();
      int[][] memo = new int[s.length()][s.length()];
      for(int i=0;i<len;i++)
        for(int j=0;j<len;j++)
            memo[i][j]=-1;
      for(int i=s.length()-1;i>=0;i--)
            sb.append(s.charAt(i));
        return checkLongMemo(s,sb.toString(),0,0,memo);
    }
    private int checkLongMemo(String s1, String s2,int ind1, int ind2,int[][] memo) {
        if(s1.length()==ind1 || s2.length()==ind2) return 0;
        if(memo[ind1][ind2]!= -1) return memo[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)) return memo[ind1][ind2]=1+checkLongMemo(s1,s2,ind1+1,ind2+1,memo);
        else  return memo[ind1][ind2]=Math.max(checkLongMemo(s1,s2,ind1+1,ind2,memo),checkLongMemo(s1,s2,ind1,ind2+1,memo));
    }

     public int longestPalindromeSubseqTabu(String s) {
      StringBuilder sb = new StringBuilder();
      int len = s.length();
      for(int i=len-1;i>=0;i--)
        sb.append(s.charAt(i));

    String s2 = sb.toString();
      int[][] tabu = new int[len+1][len+1];
      int ans =0;
      for(int i=1;i<=len;i++){
       for(int j=1;j<=len;j++){
        if(s.charAt(i-1)==s2.charAt(j-1)) tabu[i][j]=1+tabu[i-1][j-1];
        else tabu[i][j]=Math.max(tabu[i-1][j],tabu[i][j-1]);
        ans = Math.max(ans,tabu[i][j]);
       }
      }

    return ans;
    }

      public int longestPalindromeSubseqSpo(String s) {
      StringBuilder sb = new StringBuilder();
      int len = s.length();
      for(int i=len-1;i>=0;i--)
        sb.append(s.charAt(i));

    String s2 = sb.toString();
      int[] spo = new int[len+1];
      int ans =0;
      for(int i=1;i<=len;i++){
        int[] temp = new int[len+1];
       for(int j=1;j<=len;j++){
        if(s.charAt(i-1)==s2.charAt(j-1)) temp[j]=1+spo[j-1];
        else temp[j]=Math.max(spo[j],temp[j-1]);
        ans = Math.max(ans,temp[j]);
       }
       spo=temp;
      }

    return ans;
    }
}
public class Problem28{
    public static void main(String[] args) {
        Solution s = new Solution();
        String  ss = "bbbab";
        System.out.println("Recursive:"+s.longestPalindromeSubseqRecursive(ss));        
        System.out.println("Memoization:"+s.longestPalindromeSubseqMemo(ss));
        System.out.println("Tabulation:"+s.longestPalindromeSubseqTabu(ss));
        System.out.println("Space Optimization:"+s.longestPalindromeSubseqSpo(ss));
    }
}
