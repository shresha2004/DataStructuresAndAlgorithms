//Problem:https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
class Solution{
 public int minInsertionsRecursive(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i=s.length()-1;i>=0;i--)
            sb.append(s.charAt(i));
        int maxPalindromicSubs = insertCountRecursive(s,sb.toString(),0,0,len);

        return len - maxPalindromicSubs;

    }
    private int insertCountRecursive(String s1,String s2,int ind1,int ind2,int len){
        if(ind1 == len || ind2 == len) return 0;
        if(s1.charAt(ind1)==s2.charAt(ind2)) return 1+insertCountRecursive(s1,s2,ind1+1,ind2+1,len);
        else return Math.max(insertCountRecursive(s1,s2,ind1+1,ind2,len),insertCountRecursive(s1,s2,ind1,ind2+1,len));
    }

      public int minInsertionsMemo(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int[][] memo= new int[len][len];
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                memo[i][j]=-1;
        for(int i=s.length()-1;i>=0;i--)
            sb.append(s.charAt(i));
        int maxPalindromicSubs = insertCountMemo(s,sb.toString(),0,0,len,memo);

        return len - maxPalindromicSubs;

    }
    private int insertCountMemo(String s1,String s2,int ind1,int ind2,int len,int[][] memo){
        if(ind1 == len || ind2 == len) return 0;
        if(memo[ind1][ind2] != -1) return memo[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)) return memo[ind1][ind2]=1+insertCountMemo(s1,s2,ind1+1,ind2+1,len,memo);
        else return memo[ind1][ind2]=Math.max(insertCountMemo(s1,s2,ind1+1,ind2,len,memo),insertCountMemo(s1,s2,ind1,ind2+1,len,memo));
    }
}
public class Problem29 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "mbadm";
        System.out.println("Recursive:"+s.minInsertionsRecursive(ss));
        System.out.println("Memoization:"+s.minInsertionsMemo(ss));

    }
}
