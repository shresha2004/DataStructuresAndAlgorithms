class Solution {
    public int climbStairsOptimal(int n) {
        if(n==1) return 1;
        int prev1 = 1;
        int prev2 = 1;
        for(int i =2;i<=n;i++){
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
        }
}
public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Optimal:"+s.climbStairsOptimal(45));
    }
}
