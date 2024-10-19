//Problem:https://leetcode.com/problems/sort-colors/description/


import java.util.Arrays;
class Solution {
    public int[] sortColors(int[] nums) {
        int n=nums.length;
       nums= bubblesort(nums,n);
        return nums;
        
    }
   int[] bubblesort(int[] arr,int n){
        if(n==1){
            return null;
        }
        for(int j=0; j<=n-2;j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
          
           
        }
          bubblesort(arr,n-1);
        
         return arr;
    }
}
public class RecursiveBubbleSort {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums = {2,0,2,1,1,0};
       System.out.println(Arrays.toString(s.sortColors(nums)));
    }
}
