class Solution {
    int i=0;
    public boolean isPalindrome(String s) {
        int length =s.length();
      // boolean isPalindrome=true;
       if(i>=length/2)
        return true;
        if(s.charAt(i) != s.charAt(length-i-1)) {
             return false;
             }
        
       i++;
       
        return  isPalindrome(s);
    }
}
public class Problem7 {
    public static void main(String[] args) {
        Solution s=new Solution();
       System.out.println(s.isPalindrome("malayalam")); 
    }
}
