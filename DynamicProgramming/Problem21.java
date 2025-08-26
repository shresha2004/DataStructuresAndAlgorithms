//Problem:https://leetcode.com/problems/target-sum/description/
class Solution {
    public int findTargetSumWaysMyApproach(int[] nums, int target) {
        int n = nums.length;
        return countWaysMyApproach(nums,target,n,0,0);
    }
    private int countWaysMyApproach(int[] nums,int target,int n,int checkTarget,int index){
        if(index == nums.length){
            if(checkTarget==target) return 1;
            else return 0;

        }
        int pick1 = countWaysMyApproach(nums,target,n,checkTarget+nums[index],index+1);
        int pick2 = countWaysMyApproach(nums,target,n,checkTarget-nums[index],index+1);
        return pick1+pick2;
    }

     public int findTargetSumWaysRecursive(int[] nums, int target) {
        int n = nums.length;
        int totalSum =0;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        int[][] memo = new int[n][totalSum+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=totalSum;j++){
                memo[i][j]=-1;
            }
        }
        return countWaysRecursive(nums,target,n,0,0,totalSum,memo);
    }
    private int countWaysRecursive(int[] nums,int target,int n,int checkTarget,int index,int totalSum,int[][] memo){
        if(index == nums.length){
            int otherSum = totalSum - checkTarget;
            if((checkTarget-otherSum) == target) return 1;
            else return 0;
        }
        if(memo[index][checkTarget] != -1) return memo[index][checkTarget];
      int pick =countWaysRecursive(nums,target,n,checkTarget+nums[index],index+1,totalSum,memo);
      int notPick = countWaysRecursive(nums,target,n,checkTarget,index+1,totalSum,memo);
        return memo[index][checkTarget]=pick+notPick;
    }

      public int findTargetSumWaysMemo(int[] nums, int target) {
        int n = nums.length;
        int totalSum =0;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        int[][] memo = new int[n][totalSum+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=totalSum;j++){
                memo[i][j]=-1;
            }
        }
        return countWaysMemo(nums,target,n,0,0,totalSum,memo);
    }
    private int countWaysMemo(int[] nums,int target,int n,int checkTarget,int index,int totalSum,int[][] memo){
        if(index == nums.length){
            int otherSum = totalSum - checkTarget;
            if((checkTarget-otherSum) == target) return 1;
            else return 0;
        }
        if(memo[index][checkTarget] != -1) return memo[index][checkTarget];
      int pick =countWaysMemo(nums,target,n,checkTarget+nums[index],index+1,totalSum,memo);
      int notPick = countWaysMemo(nums,target,n,checkTarget,index+1,totalSum,memo);
        return memo[index][checkTarget]=pick+notPick;
    }

    public int findTargetSumWaysTabu(int[] nums, int target) {
        int n = nums.length;
        int totalSum =0;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        if((totalSum - target)%2 != 0 || (totalSum - target) < 0) return 0; 
        int sum = (totalSum - target)/2;
        int[][] tabu = new int[n][sum+1];
        if(nums[0]==0) tabu[0][0] = 2;
        else tabu[0][0]=1;
        if(nums[0] != 0 && nums[0]<= sum ) tabu[0][nums[0]] = 1;

        for(int i=1;i<nums.length;i++){
            for(int t=0;t<=sum;t++){
               int notPick = tabu[i-1][t];
               int pick = 0;
               if(nums[i]<= t) pick = tabu[i-1][t-nums[i]];
               tabu[i][t]=pick+notPick;
            }
        }
        return tabu[n-1][sum];
    }

  public int findTargetSumWaysSpaceOpti(int[] nums, int target) {
        int n = nums.length;
        int totalSum =0;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        if((totalSum - target)%2 != 0 || (totalSum - target) < 0) return 0; 
        int sum = (totalSum - target)/2;
        int[] spo = new int[sum+1];
        if(nums[0]==0) spo[0] = 2;
        else spo[0]=1;
        if(nums[0] != 0 && nums[0]<= sum ) spo[nums[0]] = 1;

        for(int i=1;i<nums.length;i++){
            int[] temp = new int[sum+1];
            for(int t=0;t<=sum;t++){
               int notPick = spo[t];
               int pick = 0;
               if(nums[i]<= t) pick = spo[t-nums[i]];
               temp[t]=pick+notPick;
            }
            spo = temp;
        }
        return spo[sum];
    }
  
}
public class Problem21 {
    public static void main(String[] args) {
        Solution s = new  Solution();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println("Recursion:"+s.findTargetSumWaysMyApproach(nums, target));
        System.out.println("Memoization:"+s.findTargetSumWaysMemo(nums, target));
        System.out.println("Tabulation:"+s.findTargetSumWaysTabu(nums, target));
        System.out.println("Space Optimization:"+s.findTargetSumWaysSpaceOpti(nums, target));
    }
}
