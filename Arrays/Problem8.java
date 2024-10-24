//Problem:https://leetcode.com/problems/missing-number/description/
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int missingNo=nums.length,i,j;
        boolean present;
        for(i=0;i<n;i++){
            present=false;
            for(j=0;j<n;j++){
                if(nums[j]==i){
                    present=true;
                   
                    break;
                } 
            }
          
            if(present==false){
                missingNo=i;
                break;
            }
        }
        return missingNo;
        
    }
}
public class Problem8 {
    public static void main(String[] args) {
        Solution s =new Solution();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(s.missingNumber(nums));
    }
}
