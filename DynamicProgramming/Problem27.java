//Problem:https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
class Solution{
public int longestCommonSubstrTabu(String s1, String s2) {
        // code here
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] tabu = new int[l1+1][l2+1];
        int ans = 0;
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) tabu[i][j]=1+tabu[i-1][j-1];
                else tabu[i][j]=0;
                ans= Math.max(ans,tabu[i][j]);
            }
        }
        return ans;
    }

     public int longestCommonSubstrSpo(String s1, String s2) {
        // code here
        int l1 = s1.length();
        int l2 = s2.length();
        int[] spo = new int[l2+1];
        int ans = 0;
        for(int i=1;i<=l1;i++){
            int[] temp = new int[l2+1];
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) temp[j]=1+spo[j-1];
                else temp[j]=0;
                ans= Math.max(ans,temp[j]);
            }
            spo=temp;
        }
        return ans;
    }
}
public class Problem27 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "ABCDGH", s2 = "ACDGHR";
        System.out.println("Tabulation:"+s.longestCommonSubstrTabu(s1, s2));
        System.out.println("Space Optization:"+s.longestCommonSubstrSpo(s1, s2));

    }
}
