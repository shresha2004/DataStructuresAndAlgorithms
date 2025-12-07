//Problem:https://leetcode.com/problems/reverse-words-in-a-string-iii/
class Solution {
    public String reverseWords(String s) {
      String[] sArr = s.split(" ");
      int n = sArr.length;
      for(int i=0;i<n;i++){
        int left = 0;
        int right = sArr[i].length()-1;
        char[] cur = sArr[i].toCharArray();
        while(left <= right){
            char temp = cur[left];
            cur[left]=cur[right];
            cur[right]=temp;
            left++;
            right--;
        }
        sArr[i]=new String(cur);
      }
      String res = String.join(" ",sArr);
      return res;
    }
}
public class Problem36 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        Solution ss = new Solution();
        System.out.println("Solution:"+ss.reverseWords(s));
    }
}
