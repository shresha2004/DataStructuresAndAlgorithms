class Solution {
     public static int minSubsetSumDifferenceRecursive(int []nums) {
        // Write your code here.
        int totalSum = 0;
        for(int i=0;i<nums.length;i++)
            totalSum += nums[i];
       return checkSumDiffRecursive(nums,totalSum,0,0);
    }

    private static int checkSumDiffRecursive(int[] nums,int totalSum,int curSum,int index){
        if(index == nums.length){
            int OtherSum = totalSum - curSum;
            return Math.abs(OtherSum-curSum);
        }
        int pick = checkSumDiffRecursive(nums,totalSum,curSum+nums[index],index+1);
        int notPick = checkSumDiffRecursive(nums,totalSum,curSum,index+1);
        int ans = Math.min(pick,notPick);
        return ans;
    }

 public static int minSubsetSumDifferenceMemo(int[] nums) {
        // Write your code here.
        int totalSum = 0;
        for(int i=0;i<nums.length;i++)
            totalSum += nums[i];

       Integer[][] memo = new Integer[nums.length][totalSum+1];
       return checkSumDiffMemo(nums,totalSum,0,0,memo);
    }

    private static int checkSumDiffMemo(int[] nums,int totalSum,int curSum,int index,Integer[][] memo){
        if(index == nums.length){
            int OtherSum = totalSum - curSum;
            return Math.abs(OtherSum-curSum);
        }
        if(memo[index][curSum] != null) return memo[index][curSum];
        int pick = checkSumDiffMemo(nums,totalSum,curSum+nums[index],index+1,memo);
        int notPick = checkSumDiffMemo(nums,totalSum,curSum,index+1,memo);
        int ans = Math.min(pick,notPick);
        return memo[index][curSum]=ans;
    }

    public int minimumDifferenceTabulation(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
        }
        boolean[][] tabu = new boolean[nums.length][sum + 1];

        for (int i = 0; i < nums.length; i++)
            tabu[i][0] = true;

        tabu[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int t = 1; t <= sum; t++) {
                boolean notTake = tabu[i - 1][t];
                boolean take = false;
                if (nums[i] <= t)
                    take = tabu[i - 1][t - nums[i]];
                tabu[i][t] = take || notTake;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (tabu[nums.length - 1][i] == true) {
                int val1 = i;
                int val2 = sum - i;
                ans = Math.min(ans, Math.abs(val1 - val2));
            }

        }
        return ans;
    }

    public int minSubsetSumDifferenceSpo(int[] nums) {
        // Write your code here.
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += Math.abs(nums[i]);
        }
        boolean[] spo = new boolean[sum + 1];
        spo[0] = true;

        spo[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            boolean[] temp = new boolean[sum + 1];
            temp[0] = true;
            for (int t = 1; t <= sum; t++) {
                boolean notTake = spo[t];
                boolean take = false;
                if (nums[i] <= t)
                    take = spo[t - nums[i]];
                temp[t] = take || notTake;
            }
            spo = temp;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (spo[i] == true) {
                int val1 = i;
                int val2 = sum - i;
                ans = Math.min(ans, Math.abs(val1 - val2));
            }

        }
        return ans;
    }
}

public class Problem18 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Solution s = new Solution();
        System.out.println("Recurive:"+s.minSubsetSumDifferenceRecursive(arr));
        System.out.println("Memoization:"+s.minSubsetSumDifferenceMemo(arr));
        System.out.println("Tabualation:"+s.minimumDifferenceTabulation(arr));
        System.out.println("Space Optimiziation:"+s.minSubsetSumDifferenceSpo(arr));
    }
}
