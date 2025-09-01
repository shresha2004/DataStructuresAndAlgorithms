//Problem:https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1?utm_source=chatgpt.com
class Solution{
    static void lcs(String s1, String s2) {
        // code here
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] tabu= new int[l1+1][l2+1];
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) tabu[i][j]=1+tabu[i-1][j-1];
                else tabu[i][j]=Math.max(tabu[i-1][j],tabu[i][j-1]);
            }
        }
        int i=l1;
        int j=l2;
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<tabu[l1][l2];k++)
                sb.append("$");
        int index = tabu[l1][l2]-1;
        while(i>0 && j >0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.setCharAt(index, s1.charAt(i-1));
                i--;
                j--;
                index--;
            }
            else if(tabu[i-1][j]>tabu[i][j-1]){
                
                i--;
               
            }
            else{
                j--;
            }
        }
    System.out.println("Solution:"+sb);
}
}
public class Problem26 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "ABCDGH", s2 = "AEDFHR";
        s.lcs(s1, s2);

    }
}
