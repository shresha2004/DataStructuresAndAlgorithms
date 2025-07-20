package BinarySearch;
//Problem:https://leetcode.com/problems/find-target-indices-after-sorting-array/description/?envType=problem-list-v2&envId=binary-search
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> targetIndicesBruteForce(int[] nums, int target) {
        int n = nums.length;
        
        List<Integer> ans = new ArrayList<>();
        
        mergeSort(nums,0,n-1);
        for(int i=0;i<n;i++){
            if(nums[i]==target) ans.add(i);
        }
        
        
        return ans;

    }
    private void mergeSort(int[] nums,int low,int high){
        if(high <= low) return ;
        int mid = (low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    private void merge(int[] nums,int low,int mid,int high){
        int left =low;
        int right = mid+1;
        ArrayList<Integer> temp= new ArrayList<>();
        while(left <= mid && right <= high){
            if(nums[right]<nums[left]){
                temp.add(nums[right]);
                right++;
            }
            else {
                temp.add(nums[left]);
                left++;
            }
        }
        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }
       int i = low;
       for(int num : temp){
        nums[i++]=num;
       }
    }
}

public class Problem29 {
     public static void main(String[] args) {
        Solution s = new Solution();
      int[]  nums = {1,2,5,2,3};
      int target = 2;
        System.out.println("Brute Force:"+s.targetIndicesBruteForce(nums,target));
    }
}
