//Problem:https://leetcode.com/problems/reverse-string-ii/description/?envType=problem-list-v2&envId=vmt09hqd
class Solution {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int n = s.length();
        for(int i=0;i<n;i+= 2*k){
            int start = i;
            int end = Math.min(i+k-1,n-1);
            reverse(sArr,start,end);
        }
        return new String(sArr);
    }
    private void reverse(char[] s, int start, int end) {
        while (start <= end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
public class Problem29 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "abcdefg";
        System.out.println("Solution:"+s.reverseStr(ss, 2));
    }
}
