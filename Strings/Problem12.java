//Problem:https://leetcode.com/problems/longest-palindromic-substring/description/
class Solution {
    public String longestPalindromeBruteForce(String s) {
        int n = s.length();
        String subsString ="";
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String checkSub = s.substring(i,j+1);
                boolean check = checkPalindrome(checkSub);
                if(check == true && checkSub.length() > subsString.length() ){
                    subsString = checkSub;
                }
            }
        }
      return subsString;
    }
    
    private boolean checkPalindrome(String s){
        int n = s.length();
          int left=0;
        int right = n-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindromeOptimal(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len = Math.max(len1,len2);

            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len / 2;

            }
        }
        return s.substring(start, end+1);
    }
    private int expand(String s, int left,int right){
        while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

}
public class Problem12 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "babad";
        System.out.println("Brute Force:"+s.longestPalindromeBruteForce(ss));
        System.out.println("Optimal:"+s.longestPalindromeOptimal(ss));
    }
}
