//Problem:https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1
class Solution{
public static int findXORBruteForce(int l, int r) {
        int ans = 0;
        for(int i=l;i<=r;i++){
            ans ^=i;
        }
        return ans;
    }
}
public class Problem12 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int L = 4, R = 8 ;
        System.out.println("Brute Force:"+s.findXORBruteForce(L, R));
    }
}

