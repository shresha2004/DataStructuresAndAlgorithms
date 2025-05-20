//Problem:https://www.geeksforgeeks.org/problems/set-kth-bit3724/1
class Solution{
  static int setKthBitOptimal(int n, int k) {
        // code here
        return (n | (1<<k));
    }
}
public class Problem2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num =10 ;
        System.out.println("Optimal:"+s.setKthBitOptimal(num,2));
    }
}

