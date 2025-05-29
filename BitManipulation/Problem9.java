//Problem:https://leetcode.com/problems/xor-operation-in-an-array/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
 public int xorOperation(int n, int start) {
        int[] ans = new int[n];
        int xor = 0;
        for(int i=0;i<n;i++){
            ans[i]=start+2*i;
            xor = xor ^ ans[i];
        }
    return xor;
    }
}
public class Problem9 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5, start = 0;
        System.out.println("Solution:"+s.xorOperation(n, start));
    }
}

