class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

     
        int maxCons=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                maxCons=Math.max(maxCons,count);
            }
            else{
                count=0;
            }
        }
    return maxCons;
        
      
    }
}

public class Problem9 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums = {1,1,0,1,1,1};
        System.out.println(s.findMaxConsecutiveOnes(nums));
    }
    
}
