
//Problem:https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        boolean checkSorted=true;
        int count=0;
       for(int i=0;i<n;i++){
        if(nums[i]>nums[(i+1)%n]){
            count++;
        }
        if(count>1){ 
            checkSorted=false;
            break;
        }
       }
        return checkSorted;
    }
}
public class Problem3 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {3,4,5,1,2};
        System.out.println(s.check(nums));
    }
    
}
