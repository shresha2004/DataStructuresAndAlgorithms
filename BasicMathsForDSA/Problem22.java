//Problem:
class Solution {
    public int alternatingSum(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0) ans+=nums[i];
            else ans-=nums[i];
        }
        return ans;
    }
}
public class Problem22 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        Solution s = new Solution();
        System.out.println("Solution:"+s.alternatingSum(nums));
    }
}
