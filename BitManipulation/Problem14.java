//Problem:https://leetcode.com/problems/add-binary/description/?envType=problem-list-v2&envId=bit-manipulation
class Solution{
 public String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();
    int i= a.length()-1;
    int j = b.length()-1;
    int carry = 0;
    while(i>=0||j>=0||carry != 0){
        int sum = carry;
        if(i>=0) sum += a.charAt(i--)- '0';
        if(j>=0) sum += b.charAt(j--)-'0';
        res.append(sum%2);
        carry = sum/2;
    }
    return res.reverse().toString();
    }
}
public class Problem14 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "11", b = "1";
        System.out.println("Solution:"+s.addBinary(a, b));
    }
}

