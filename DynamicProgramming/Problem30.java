//Problem:https://leetcode.com/problems/delete-operation-for-two-strings/description/
class Solution{
     public int minDistanceRecursive(String word1, String word2) {
        int lcs = findLcsRecursive(word1,word2,0,0);
        int min = word1.length()-lcs;
        min+=word2.length()-lcs;
        return min;
    }
    private int findLcsRecursive(String word1,String word2,int ind1,int ind2){
        if(word1.length()== ind1 || word2.length()==ind2) return 0;
        if(word1.charAt(ind1)==word2.charAt(ind2)) return 1+findLcsRecursive(word1,word2,ind1+1,ind2+1);
        else return Math.max(findLcsRecursive(word1,word2,ind1+1,ind2),findLcsRecursive(word1,word2,ind1,ind2+1));
    }
 public int minDistanceMemo(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] memo = new int[len1][len2];
        for(int i=0;i<len1;i++)
            for(int j=0;j<len2;j++)
                memo[i][j]=-1;
        int lcs = findLcsMemo(word1,word2,0,0,memo);
        int min = word1.length()-lcs;
        min+=word2.length()-lcs;
        return min;
    }
    private int findLcsMemo(String word1,String word2,int ind1,int ind2,int[][] memo){
        if(word1.length()== ind1 || word2.length()==ind2) return 0;
        if(memo[ind1][ind2] != -1) return memo[ind1][ind2];
        if(word1.charAt(ind1)==word2.charAt(ind2)) return memo[ind1][ind2]=1+findLcsMemo(word1,word2,ind1+1,ind2+1,memo);
        else return memo[ind1][ind2]=Math.max(findLcsMemo(word1,word2,ind1+1,ind2,memo),findLcsMemo(word1,word2,ind1,ind2+1,memo));
    }

    public int minDistanceTabu(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] tabu = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    tabu[i][j]=1+tabu[i-1][j-1];
                }
                else tabu[i][j]=Math.max(tabu[i-1][j],tabu[i][j-1]);
            }}
        int lcs = tabu[len1][len2];
        int min = word1.length()-lcs;
        min+=word2.length()-lcs;
        return min;
    }

      public int minDistanceSpo(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[] spo = new int[len2+1];
        for(int i=1;i<=len1;i++){
            int[] temp = new int[len2+1];
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                   temp[j]=1+spo[j-1];
                }
                else temp[j]=Math.max(spo[j],temp[j-1]);
            }
            spo=temp;
            }
        int lcs =spo[len2];
        int min = word1.length()-lcs;
        min+=word2.length()-lcs;
        return min;
    }
}
public class Problem30 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String word1 = "sea", word2 = "eat";
        System.out.println("Solution:"+s.minDistanceRecursive(word1, word2));
        System.out.println("Memoization:"+s.minDistanceMemo(word1, word2));
        System.out.println("Tabulation:"+s.minDistanceTabu(word1, word2));
        System.out.println("Space Optimization:"+s.minDistanceSpo(word1, word2));
    }
}
