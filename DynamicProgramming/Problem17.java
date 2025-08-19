//Problem:https://leetcode.com/problems/partition-equal-subset-sum/description/
class Solution {
    // Recursive
    public boolean canPartitionRecursive(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 == 1)
            return false;
        int checkSum = (sum / 2);
        Boolean[][] memo = new Boolean[nums.length][checkSum + 1];

        return checkSumRecursive(nums, sum / 2, 0, memo);
    }

    private boolean checkSumRecursive(int[] nums, int checkSum, int index, Boolean[][] memo) {
        if (index >= nums.length)
            return false;
        if (checkSum < 0)
            return false;
        if (memo[index][checkSum] != null)
            return memo[index][checkSum];
        if (checkSum == 0)
            return true;
        boolean take = checkSumRecursive(nums, checkSum - nums[index], index + 1, memo);
        boolean notTake = checkSumRecursive(nums, checkSum, index + 1, memo);
        return memo[index][checkSum] = take || notTake;
    }

    // Memoization
    public boolean canPartitionMemo(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 == 1)
            return false;
        int checkSum = (sum / 2);
        Boolean[][] memo = new Boolean[nums.length][checkSum + 1];

        return checkSumMemo(nums, sum / 2, 0, memo);
    }

    private boolean checkSumMemo(int[] nums, int checkSum, int index, Boolean[][] memo) {
        if (index >= nums.length)
            return false;
        if (checkSum < 0)
            return false;
        if (memo[index][checkSum] != null)
            return memo[index][checkSum];
        if (checkSum == 0)
            return true;
        boolean take = checkSumMemo(nums, checkSum - nums[index], index + 1, memo);
        boolean notTake = checkSumMemo(nums, checkSum, index + 1, memo);
        return memo[index][checkSum] = take || notTake;
    }

    public boolean canPartitionTabu(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 == 1)
            return false;
        int checkSum = (sum / 2);
        boolean[][] tabu = new boolean[nums.length][checkSum + 1];
        for (int i = 0; i < tabu.length; i++) {
            tabu[i][0] = true;
        }
        if (nums[0] <= checkSum)
            tabu[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int target = 1; target <= checkSum; target++) {
                boolean notTake = tabu[i - 1][target];
                boolean take = false;
                if (nums[i] <= target)
                    take = tabu[i - 1][target - nums[i]];
                tabu[i][target] = take || notTake;
            }
        }
        return tabu[nums.length - 1][checkSum];
    }

    public boolean canPartitionSpo(int[] nums) {
     int sum =0;
    for(int i=0;i<nums.length;i++) sum+=nums[i];
     if(sum%2==1)    return false;
     int checkSum = (sum/2);


     boolean[]  spo= new boolean[checkSum+1];
      spo[0] = true;
  if(nums[0]<=checkSum)  spo[nums[0]]= true;
  for(int i=1;i<nums.length;i++){
    boolean[] temp = new boolean[checkSum+1];
    temp[0]= true;
    for(int target = 1; target <= checkSum;target++){
        boolean notTake = spo[target];
        boolean take = false;
        if(nums[i]<= target) take = spo[target-nums[i]];
       temp[target]=take || notTake;
    }
    spo= temp;
  }
    return spo[checkSum];
    }
}

public class Problem17 {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };
        Solution s = new Solution();
        System.out.println("Recursive:" + s.canPartitionRecursive(nums));
        System.out.println("Memoization:" + s.canPartitionMemo(nums));
        System.out.println("Tabulation:"+s.canPartitionTabu(nums));
        System.out.println("Space Optimization:"+s.canPartitionSpo(nums));
    }
}
