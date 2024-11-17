//Problem:https://leetcode.com/problems/next-permutation/description/
import java.util.Arrays;
class Solution {
    public int[] nextPermutationOptimal(int[] nums) {
        int n=nums.length;
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
            if(ind==-1){
                
                reverse(nums,0,n-1);
                return nums;
            }

            for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                break;
            }
            }
        
      return  reverse(nums,ind+1,n-1);
        
    }
    private int[]  reverse(int[]  array,int left,int right){
        
        while(left<right){
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
        return array;
    }

  
}
public class Problem24 {

    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {1,2,3};
      System.out.println("BruteForce Approach:"+Arrays.toString(s.nextPermutationOptimal(nums)));
     
     
    }
}
