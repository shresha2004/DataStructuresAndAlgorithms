//Problem:https://www.geeksforgeeks.org/problems/replace-the-bit3212/1
class Solution{
 int replaceBit(int N, int K) {
       String inBinary = Integer.toBinaryString(N);
       int len = inBinary.length();
     
        return N & ~(1<<(len-K));
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 13;
        int k=2;
        System.out.println("Optimal:"+s.replaceBit(num, k));
    }
}

