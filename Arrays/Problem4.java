//Problem:https://leetcode.com/problems/rotate-array/description/
import java.util.Arrays;
class Solution {
    public void rotateBruteForce(int[] nums, int k) {
        int n=nums.length;
        for(int i=0;i<k;i++){
            int temp=nums[n-1];
            for(int j=nums.length-1;j>0;j--){
                nums[j]=nums[j-1];
 
            }
            nums[0]=temp;
        }
       System.out.println(Arrays.toString(nums));
        
    }
    public void rotateOptimal(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        System.err.println(Arrays.toString(nums));    
    }
    public void reverse(int nums[],int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a1={1,2,3,4,5,6,7};
        int[] a2={1,2,3,4,5,6,7};
        s.rotateBruteForce(a1, 3);
        s.rotateOptimal(a2, 3);

    }
    
}
