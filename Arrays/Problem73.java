//Problem:https://leetcode.com/problems/find-triangular-sum-of-an-array/description/?envType=daily-question&envId=2025-09-30
class Solution{
  public int triangularSum(int[] nums) {
        int n=nums.length;
        for(int i=n-1;i>0;i--){
          int[] temp = new int[i];
            for(int j=0;j<i;j++){
                int sum = nums[j]+nums[j+1];
                 sum = sum %10;
                 temp[j]=sum;
            }
          nums=temp;
        }
        return nums[0];
    }
}
public class Problem73 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3,4,5};
        System.out.println("Solution:"+s.triangularSum(arr));
    }
}
