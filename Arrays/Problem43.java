//Problem:https://leetcode.com/problems/maximum-product-subarray/description/
class Solution {
    public int maxProductBruteForce(int[] nums) {
        int n = nums.length;
       
        int product = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    int checkProduct=1;
                    for(int k=i;k<=j;k++)
                            checkProduct *= nums[k];
                        product =Math.max(checkProduct,product);
            }
            
        }
        return product;
    }
}
public class Problem43 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] arr = {2,3,-2,4};
       System.out.println("Brute Force Approach:"+s.maxProductBruteForce(arr)); 
  // System.out.println("Optimal Approach:"+s.reversePairsOptimal(arr)); 
    }
    
}
