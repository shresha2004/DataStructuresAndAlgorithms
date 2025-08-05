//Problem:https://leetcode.com/problems/house-robber-ii/description/
class Solution {
     public int robRecursive(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        for(int i=0;i<n;i++){
            if(i!= 0) temp1[i-1]=nums[i];
            if(i != (n-1)) temp2[i]=nums[i];
        }
        return Math.max(robingRecursive(n-2,temp1),robingRecursive(n-2,temp2));
    }

    private int robingRecursive(int n,int[] nums){
        if(n==0) return nums[0];
        if(n<0) return 0;
        int take = nums[n]+robingRecursive((n-2),nums);
        int notTake = robingRecursive(n-1,nums);
        return Math.max(take,notTake);

    }
    public int robMemoization(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        int[] memo1 = new int[n-1];
        int[] memo2 = new int[n-1];
        for(int i=0;i<n;i++){
            
            if(i!= 0) temp1[i-1]=nums[i];
            if(i != (n-1)){ temp2[i]=nums[i];
            memo1[i]=-1;
            memo2[i]=-1;
            }
        }
        return Math.max(robingMemo(n-2,temp1,memo1),robingMemo(n-2,temp2,memo2));
    }

    private int robingMemo(int n,int[] nums,int[] memo){
        if(n==0) return nums[0];
        if(n<0) return 0;
        if(memo[n]!=-1) return memo[n];
        int take = nums[n]+robingMemo((n-2),nums,memo);
        int notTake = robingMemo(n-1,nums,memo);
        return memo[n]=Math.max(take,notTake);

    }
     public int robTabulation(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        int[] tabu1 = new int[n-1];
        int[] tabu2 = new int[n-1];
        for(int i=0;i<n;i++){
            
            if(i!= 0) temp1[i-1]=nums[i];
            if(i != (n-1)){ 
                temp2[i]=nums[i];
          
            }
        }
        return Math.max(robingTabu(n-2,temp1,tabu1),robingTabu(n-2,temp2,tabu2));
    }

    private int robingTabu(int n,int[] nums,int[] tabu){
       tabu[0]=nums[0];
       for(int i=1;i<nums.length;i++){
        int pick = nums[i];
        if(i>1) pick+=tabu[i-2];
        int notPick = tabu[i-1];
        tabu[i]=Math.max(pick,notPick);
       }
 return tabu[nums.length-1];
    }


     public int robSpaceOpti(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        int[] tabu1 = new int[n-1];
        int[] tabu2 = new int[n-1];
        for(int i=0;i<n;i++){
            
            if(i!= 0) temp1[i-1]=nums[i];
            if(i != (n-1)){ 
                temp2[i]=nums[i];
          
            }
        }
        return Math.max(robingSpaceOpti(n-2,temp1,tabu1),robingSpaceOpti(n-2,temp2,tabu2));
    }

    private int robingSpaceOpti(int n,int[] nums,int[] tabu){
       int prev1=nums[0];
       int prev2 =0;
       for(int i=1;i<nums.length;i++){
        int pick = nums[i];
        if(i>1) pick+=prev2;
        int notPick = prev1;
        int cur=Math.max(pick,notPick);
        prev2 = prev1;
        prev1 =cur;
       }
 return prev1;
    }
}
public class Problem7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,3,2};
        System.out.println("Recursive:"+s.robRecursive(nums));
        System.out.println("Memoization:"+s.robMemoization(nums));
        System.out.println("Tabulation:"+s.robTabulation(nums));
        System.out.println("Space Optimizaton:"+s.robSpaceOpti(nums));
    }
}
