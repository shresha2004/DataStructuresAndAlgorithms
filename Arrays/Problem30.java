class Solution {
    public int subarraySumBruteForce(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
               sum=sum+nums[j];
               if(sum==k) count++;
            }
        }
        return count;
    }
}
public class Problem30 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {1,2,3};
       int k = 3;
    System.out.println("BruteForce Approach:"+s.subarraySumBruteForce(nums,k));
 
    }
    
}
