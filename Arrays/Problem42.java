class Solution {
    public int reversePairsBruteForce(int[] nums) {
        int n =nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                long check= 2L *  nums[j];
                if(i<j && nums[i]>check) count++;
            }
        }
       return count; 
    }
}
public class Problem42 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] arr = {1,3,2,3,1};
       System.out.println("Brute Force Approach:"+s.reversePairsBruteForce(arr)); 
     // System.out.println("Optimal Approach:"+s.inversionCountOptimal(arr)); 
    }
}
