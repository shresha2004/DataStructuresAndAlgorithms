//Problem:https://leetcode.com/problems/edit-distance/description/
import java.util.Arrays;
class Solution{
  public int minDistanceRecursive(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        return checkDistanceRecursive(word1,word2,len1-1,len2-1);
    }
    private int checkDistanceRecursive(String word1,String word2,int len1,int len2){
        if(len1 <  0) return len2+1;
        if(len2 < 0) return len1+1;
        if(word1.charAt(len1) == word2.charAt(len2)){
            return checkDistanceRecursive(word1,word2,len1-1,len2-1);
        }
        else{
            int insert = 1+checkDistanceRecursive(word1,word2,len1,len2-1);
            int delete = 1+checkDistanceRecursive(word1,word2,len1-1,len2);
            int replace = 1+checkDistanceRecursive(word1,word2,len1-1,len2-1);
            return Math.min(insert,Math.min(delete,replace));
        }
    }
     public int minDistanceMemo(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] memo = new int[len1][len2];
        for(int i=0;i<len1;i++)
            Arrays.fill(memo[i],-1);
        return checkDistanceMemo(word1,word2,len1-1,len2-1,memo);
    }
    private int checkDistanceMemo(String word1,String word2,int len1,int len2,int[][] memo){
        if(len1 <  0) return len2+1;
        if(len2 < 0) return len1+1;
        if(memo[len1][len2] != -1) return memo[len1][len2];
        if(word1.charAt(len1) == word2.charAt(len2)){
            return memo[len1][len2]=checkDistanceMemo(word1,word2,len1-1,len2-1,memo);
        }
        else{
            int insert = 1+checkDistanceMemo(word1,word2,len1,len2-1,memo);
            int delete = 1+checkDistanceMemo(word1,word2,len1-1,len2,memo);
            int replace = 1+checkDistanceMemo(word1,word2,len1-1,len2-1,memo);
            return memo[len1][len2]=Math.min(insert,Math.min(delete,replace));
        }
    }
    public int minDistanceTabu(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] tabu = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++) tabu[i][0]=i;
        for(int j=1;j<=len2;j++) tabu[0][j]=j;

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                        tabu[i][j]=tabu[i-1][j-1];
                else tabu[i][j]=1+Math.min(tabu[i-1][j-1],Math.min(tabu[i][j-1],tabu[i-1][j]));
            }
        }
        return tabu[len1][len2];
    }
   
    
}
public class Problem33 {
    public static void main(String[] args) {
        Solution s = new Solution();
       String word1 = "horse", word2 = "ros";
        System.out.println("Recursive:"+s.minDistanceRecursive(word1, word2));
        System.out.println("Memoization:"+s.minDistanceMemo(word1, word2));
        System.out.println("Tabulation:"+s.minDistanceTabu(word1, word2));

    }
}
