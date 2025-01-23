package BinarySearch;
//Problem:https://leetcode.com/problems/single-element-in-a-sorted-array/description/
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

    public int singleNonDuplicateOptimal(int[] nums) {
        int n = nums.length;
      if (n==1) return nums[0];
      else if(nums[0] != nums[1]) return nums[0];
      else if( nums[n-2] != nums[n-1]) return nums[n-1];
      int low = 1;
      int high = n-2;
      while(low<=high){
        int mid = (low+high)/2;
        if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) return nums[mid];
        if( (mid%2 == 0 && nums[mid]== nums[mid+1]) || (mid%2 == 1 && nums[mid] == nums[mid-1])){
            low = mid+1;
        }
        else {
            high = mid-1;
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
        System.out.println("Optimal:"+s.singleNonDuplicateOptimal(nums));
    }
}
