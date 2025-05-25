//Problem:https://www.geeksforgeeks.org/problems/toggle-bits-given-range0952/1
class Solution{
 static int toggleBits(int n, int l, int r) {
        // code here
        for(int i=l;i<=r;i++){
            n=(n ^(1<<i-1));
            
        }
        return n;
    }
}
public class Problem6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num =17 ;
        System.out.println("Brute Force:"+s.toggleBits(num, 2, 3));
    }
}

