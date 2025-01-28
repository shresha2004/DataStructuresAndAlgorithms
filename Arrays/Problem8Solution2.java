class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
       
        int sum1=((n)*(n+1))/2;
        int sum2=0;
        for(int i=0;i<n;i++){
            sum2=sum2+nums[i];
        }
        int total=sum1-sum2;
        
        return total;
        
    }
}
public class Problem8Solution2 {
 public static void main(String[] args) {
    Solution s =new Solution();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(s.missingNumber(nums));
    
 }   
}
