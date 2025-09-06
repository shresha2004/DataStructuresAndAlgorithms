//Problem:https://leetcode.com/problems/distinct-subsequences/description/
class Solution{
    public int numDistinctRecursive(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        return  findDistinctRecursive(s, t, len1-1,len2-1);
    }

    private int findDistinctRecursive(String s, String t, int len1,int len2){
        if(len2<0) return 1;
        if(len1 < 0) return 0;
        if(s.charAt(len1)==t.charAt(len2)) return findDistinctRecursive(s,t,len1-1,len2-1)+findDistinctRecursive(s,t,len1-1,len2);
        else return findDistinctRecursive(s,t,len1-1,len2);
    }

      public int numDistinctMemo(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] memo = new int[len1][len2];
        for(int i=0;i<len1;i++)
            for(int j=0;j<len2;j++)
                memo[i][j]=-1;
        return  findDistinctMemo(s, t, len1-1,len2-1,memo);
    }

    private int findDistinctMemo(String s, String t, int len1,int len2,int[][] memo){
        if(len2<0) return 1;
        if(len1 < 0) return 0;
        if(memo[len1][len2] != -1) return memo[len1][len2];
        if(s.charAt(len1)==t.charAt(len2)) return memo[len1][len2]=findDistinctMemo(s,t,len1-1,len2-1,memo)+findDistinctMemo(s,t,len1-1,len2,memo);
        else return memo[len1][len2]=findDistinctMemo(s,t,len1-1,len2,memo);
    }

     public int numDistinctTabu(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] tabu = new int[len1+1][len2+1];
          for(int i=0;i<=len1;i++) tabu[i][0]=1;
        for(int j=1;j<=len2;j++) tabu[0][j]=0;

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    tabu[i][j]=tabu[i-1][j-1]+tabu[i-1][j];
                }
                else tabu[i][j]= tabu[i-1][j];
            }
        }
        return tabu[len1][len2];
     }

     public int numDistinctSpo(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[] spo = new int[len2+1];
        spo[0]=1;
        for(int i=1;i<=len1;i++){
            int[] temp = new int[len2+1];
            temp[0]=1;
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    temp[j]=spo[j-1]+spo[j];
                }
                else temp[j]= spo[j];
            }
            spo=temp;
        }
        return spo[len2];
     }

      public int numDistinctSpo2(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[] spo = new int[len2+1];
        spo[0]=1;
        for(int i=1;i<=len1;i++){
            for(int j=len2;j>0;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    spo[j]=spo[j-1]+spo[j];
                }
            }
           
        }
        return spo[len2];
     }
}
public class Problem32 {
    public static void main(String[] args) {
        Solution ss = new Solution();
        String s = "rabbbit", t = "rabbit";
        System.out.println("Recursive:"+ss.numDistinctRecursive(s, t));
        System.out.println("Memoization:"+ss.numDistinctMemo(s, t));
        System.out.println("Tabulation:"+ss.numDistinctTabu(s, t));
        System.out.println("Space Optimization:"+ss.numDistinctSpo(s, t));
        System.out.println("Space Optimization 2:"+ss.numDistinctSpo2(s, t));
    }
}
