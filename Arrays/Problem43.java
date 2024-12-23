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
    public int maxProductBetter(int[] nums) {
        int n = nums.length;
       
        int product = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
              int checkProduct=1;
                for(int j=i;j<n;j++){
                            checkProduct *= nums[j];
                        product =Math.max(checkProduct,product);
            }
            
        }
        return product;
    }

    public int maxProductOptimal(int[] nums) {
        int n = nums.length;
       
        int product = Integer.MIN_VALUE;
        int prefix=1;
        int sufix=1;
        
        for(int i=0;i<n;i++){
             if(prefix==0) prefix=1;
             if(sufix==0) sufix=1;

             prefix *= nums[i];
             sufix *= nums[n-i-1];
             product=Math.max(product,Math.max(prefix,sufix));
            
        }
        return product;
    }
}
public class Problem43 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] arr = {2,3,-2,4};
       System.out.println("Brute Force Approach:"+s.maxProductBruteForce(arr)); 
       System.out.println("Better Force Approach:"+s.maxProductBetter(arr)); 
     System.out.println("Optimal Approach:"+s.maxProductOptimal(arr)); 
     System.out.println("Optimal Approach:"+s.maxProductOptimal(arr)); 
    }
    
}
