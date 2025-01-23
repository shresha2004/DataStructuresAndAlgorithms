package BinarySearch;

class Solution {
    public int singleNonDuplicateBruteForce(int[] nums) {
        int n = nums.length;
      if (n==1) return nums[0];
      for(int i=0;i<n;i++){
        if(i==0){
            if(nums[i] != nums[i+1]) return nums[i];
        }
        else if(i==n-1){
                if(nums[i] != nums[i-1]) return nums[i];
            }
        else{
                if(nums[i] != nums[i+1] && nums[i] != nums[i-1]) return nums[i];
            }
        
      }
      return 0;
    }
}
   

public class Problem12 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println("Brute Force:"+s.singleNonDuplicateBruteForce(nums));
    }
}
