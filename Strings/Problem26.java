class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals((str2+str1))) return "";
        int gcdLen = gcd(str1.length(),str2.length());
        return str1.substring(0,gcdLen);
    }
    private int gcd(int a,int b){
        if(a == 0) return b;
        if(b==0) return a;
        if(a>b) return gcd(a%b,b);
        else return gcd(a,b%a);
    }
}
public class Problem26 {
  public static void main(String[] args) {
    Solution s = new Solution();
    String str1 = "ABCABC", str2 = "ABC";
    System.out.println("Solution:"+s.gcdOfStrings(str1, str2));
  }   
}
