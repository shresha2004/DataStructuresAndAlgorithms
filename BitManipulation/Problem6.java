//Problem:https://www.geeksforgeeks.org/problems/toggle-bits-given-range0952/1
class Solution{
 static int toggleBitsBruteForce(int n, int l, int r) {
        // code here
        for(int i=l;i<=r;i++){
            n=(n ^(1<<i-1));
            
        }
        return n;
    }
     static int toggleBitsOptimal(int n, int l, int r) {
        // code here
        int mask = (((1<<r)-1) ^ ((1<<(l-1))-1));
        return n ^ mask;
    }
}
public class Problem6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num =17 ;
        System.out.println("Brute Force:"+s.toggleBitsBruteForce(num, 2, 3));
        System.out.println("Optimal:"+s.toggleBitsOptimal(num, 2, 3));
    }
}

