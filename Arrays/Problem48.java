

//Problem:https://leetcode.com/problems/third-maximum-number/description/

import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int thirdMaxBruteForce(int[] nums) {
        int n = nums.length;
        int count = 0;
        mergeSort(nums,0,n-1);
        System.out.println(Arrays.toString(nums));
        
        for(int i=n-1;i>=0;i--){
            if(i==n-1 ||  nums[i] != nums[i+1]  ){
                count++;
            }
            if(count >= 3 ) return nums[i];
        }
        return nums[n-1];
    }

    public int thirdMaxOptimal(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        Integer n =  nums.length;
        for(Integer num : nums){
         if(num.equals(first) || num.equals(second) || num.equals(third)) continue;
 
         if(first == null || num > first){
             third = second;
             second = first;
             first = num;
         }
         else if( second == null || num > second){
             third = second;
             second = num;
         }
         else if ( third == null || num > third){
             third = num;
         }
        }
 
        return (third == null) ? first : third;
     }

    private void mergeSort(int[] nums,int low,int high){
        if(high <= low) return;
        int mid = (low + high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    private void merge(int[] nums,int low,int mid,int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(nums[right] <= nums[left]){
                temp.add(nums[right]);
                right++;

            }
            else {
                temp.add(nums[left]);
                left++;
            }
        }
        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= high){
            temp.add(nums[right]);
            right++;
        }
        int i =low;
        for(int num : temp){
            nums[i++] = num;
        }
    }
}



public class Problem48 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,1};

        System.out.println("Brute Force:"+s.thirdMaxBruteForce(nums));
        System.out.println("Optimal:"+s.thirdMaxOptimal(nums));
    }
}
