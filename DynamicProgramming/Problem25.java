//Problem:https://leetcode.com/problems/longest-common-subsequence/description/
class Solution{
    //Recursive
  public int longestCommonSubsequenceRecursive(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] memo = new int[len1][len2];
        
        for(int i=0;i<len1;i++)
            for(int j=0;j<len2;j++)
                memo[i][j]=-1;
     return maxSubRecursive(text1,text2,text1.length()-1,text2.length()-1,memo);
    }
    private int maxSubRecursive(String text1,String text2,int ind1,int ind2,int[][] memo){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(memo[ind1][ind2] != -1) return memo[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2)) return memo[ind1][ind2]=1+maxSubRecursive(text1,text2,ind1-1,ind2-1,memo);
        else return memo[ind1][ind2]=0+Math.max(maxSubRecursive(text1,text2,ind1-1,ind2,memo),maxSubRecursive(text1,text2,ind1,ind2-1,memo));
    }

    //Memoization
      public int longestCommonSubsequenceMemo(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] memo = new int[len1][len2];
        
        for(int i=0;i<len1;i++)
            for(int j=0;j<len2;j++)
                memo[i][j]=-1;
     return maxSubMemo(text1,text2,text1.length()-1,text2.length()-1,memo);
    }
    private int maxSubMemo(String text1,String text2,int ind1,int ind2,int[][] memo){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(memo[ind1][ind2] != -1) return memo[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2)) return memo[ind1][ind2]=1+maxSubMemo(text1,text2,ind1-1,ind2-1,memo);
        else return memo[ind1][ind2]=0+Math.max(maxSubMemo(text1,text2,ind1-1,ind2,memo),maxSubMemo(text1,text2,ind1,ind2-1,memo));
    }
}
public class Problem25 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String text1 = "abcde", text2 = "ace" ;
        System.out.println("Recursive:"+s.longestCommonSubsequenceRecursive(text1, text2));
        System.out.println("Memoization:"+s.longestCommonSubsequenceMemo(text1, text2));

    }
}
