//Problem:https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
    public String firstPalindromeOptimal(String[] words) {
        int n = words.length;
        for(int i=0;i<n;i++){
            if(checkPalindrome(words[i])) return words[i];
        }
    return "";
    }
    public boolean checkPalindrome(String word){
        int left = 0;
        int right = word.length()-1;
        while(left <= right){
            if(word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
public class Problem20 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ss= {"abc","car","ada","racecar","cool"};
        System.out.println("Optimal:"+s.firstPalindromeOptimal(ss));
       // System.out.println("Optimal:"+s.);
    }
}
