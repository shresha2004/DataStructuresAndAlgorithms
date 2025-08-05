//Problem:https://leetcode.com/problems/house-robber/description/
class Solution {
    public int robRecursive(int[] nums) {
     int n = nums.length;
     int[] memo = new int[n];
     for(int i=0;i<n;i++){
        memo[i] = -1;
     }
     return traverseRecursive(nums,n-1,memo);
    }
    private int traverseRecursive(int[] nums,int n,int[] memo){
        if(n== 0) return nums[0];
        if(n<0) return 0;
        if(memo[n] != -1) return memo[n];
        int pick =  nums[n]+traverseRecursive(nums,n-2,memo);
        int notPick = traverseRecursive(nums,n-1,memo);
        return memo[n]=Math.max(pick,notPick);
    }
    public int robMemo(int[] nums) {
     int n = nums.length;
     int[] memo = new int[n];
     for(int i=0;i<n;i++){
        memo[i] = -1;
     }
     return traverseMemo(nums,n-1,memo);
    }
    private int traverseMemo(int[] nums,int n,int[] memo){
        if(n== 0) return nums[0];
        if(n<0) return 0;
        if(memo[n] != -1) return memo[n];
        int pick =  nums[n]+traverseMemo(nums,n-2,memo);
        int notPick = traverseMemo(nums,n-1,memo);
        return memo[n]=Math.max(pick,notPick);
    }

     public int robTabulation(int[] nums) {
     int n = nums.length;
     int[] tabu = new int[n];
     tabu[0]=nums[0];
     int neg = 0;
     for(int i=1;i<n;i++){
        int take = nums[i];
        if(i>1) take+= tabu[i-2];
        int notTake = tabu[i-1];
        tabu[i]=Math.max(take,notTake);
     }
     return tabu[n-1];
    }

     public int robSpaceOpti(int[] nums) {
     int n = nums.length;
     int prev1=nums[0];
     int prev2 = 0;
     for(int i=1;i<n;i++){
        int take = nums[i];
        if(i>1) take+= prev2;
        int notTake = prev1;
        int cur =Math.max(take,notTake);
        prev2=prev1;
        prev1=cur;
     }
     return prev1;
    }
    

}
public class Problem6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,1};
        System.out.println("Recursion:"+s.robRecursive(nums));
        System.out.println("Memoization:"+s.robMemo(nums));
        System.out.println("Tabulation:"+s.robTabulation(nums));
        System.out.println("Space Optimization:"+s.robSpaceOpti(nums));
    }
}
