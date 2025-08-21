class Solution {
     public int perfectSumRecurive(int[] nums, int target) {
        // code here
        return countSumRecursive(nums,target,0,0);
    }
    
    private int countSumRecursive(int[] nums,int target,int sum,int index){
        if(index == nums.length){
            return (sum == target)? 1 : 0;
        }
    
        int left = countSumRecursive(nums,target,sum+nums[index],index+1);
        int right = countSumRecursive(nums,target,sum,index+1);
        return left+right;
    }
    // Function to calculate the number of subsets with a given sum
    public int perfectSumMemo(int[] nums, int target) {
        // code here
        int[][] memo = new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<=target;j++)
                memo[i][j]=-1;
        return countSumMemo(nums,target,0,0,memo);
    }

    
    
    private int countSumMemo(int[] nums,int target,int sum,int index,int[][] memo){
        if(index == nums.length){
            return (sum == target)? 1 : 0;
        }
        if(sum > target) return 0;
        if(memo[index][sum] != -1) return memo[index][sum];
        int left = countSumMemo(nums,target,sum+nums[index],index+1,memo);
        int right = countSumMemo(nums,target,sum,index+1,memo);
        return memo[index][sum]=left+right;
    }


     public int perfectSumTabu(int[] nums, int target) {
        int n = nums.length;
    

        int[][] tabu = new int[n][target + 1];

        tabu[0][0] = (nums[0] == 0) ? 2 : 1; 

        if (nums[0] != 0 && nums[0] <= target) {
            tabu[0][nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = tabu[i - 1][t];
                int take = 0;
                if (nums[i] <= t) {
                    take = tabu[i - 1][t - nums[i]];
                }
                tabu[i][t] = (take + notTake);
            }
        }

        return tabu[n - 1][target];
    }

     public int perfectSumSpo(int[] nums, int target) {
        int n = nums.length;
    

        int[] spo = new int[target + 1];

      
        spo[0] = (nums[0] == 0) ? 2 : 1; 


        if (nums[0] != 0 && nums[0] <= target) {
            spo[nums[0]] = 1;
        }

        
        for (int i = 1; i < n; i++) {
            int[] temp = new int[target+1];
            for (int t = 0; t <= target; t++) {
                int notTake = spo[t];
                int take = 0;
                if (nums[i] <= t) {
                    take = spo[t - nums[i]];
                }
                temp[t] = (take + notTake);
            }
            spo=temp;
        }

        return spo[target];
    }
}
public class Problem19 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr= {5, 2, 3, 10, 6, 8};
        int target = 10;
        System.out.println("Recursive:"+s.perfectSumRecurive(arr, target));
        System.out.println("Memoization:"+s.perfectSumMemo(arr, target));
        System.out.println("Tabulation:"+s.perfectSumTabu(arr, target));
        System.out.println("Space Optimization:"+s.perfectSumSpo(arr, target));
    }
}
