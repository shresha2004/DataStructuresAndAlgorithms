//Problem:https://leetcode.com/problems/3sum-closest/description/?envType=problem-list-v2&envId=two-pointers
import java.util.Arrays;
class Solution {

    public int threeSumClosestBruteForce(int[] nums, int target) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int curSum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(res - target) > Math.abs(target - curSum))
                        res = curSum;
                }
            }
        }
        return res;
    }
    public int threeSumClosestOptimal(int[] nums, int target) {
        int n= nums.length;
       quickSort(nums,0,n-1);
       int res = nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int curSum = nums[i]+nums[left]+nums[right];
                if(curSum == target) return target;
                if(Math.abs(curSum-target)<Math.abs(res-target)) res = curSum;
                if(curSum > target) right--;
                else left++;
            }
        }

       return res;
    }
    private void quickSort(int[] nums,int low,int high){
        if(low < high){
            int p = partition(nums,low,high);
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);
        }
    }
    private int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        int i=low;
        int j = high;
        while(i<=j){
            while(i<=high && nums[i] <= pivot) i++;
            while(j>=low && nums[j] > pivot) j--;
            if(i<j){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp = nums[low];
        nums[low]= nums[j];
        nums[j]=temp;
        return j;
    }
}

public class Problem66 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {-1,2,1,-4};
        System.out.println("Brute Force:"+s.threeSumClosestBruteForce(arr, 1));
       System.out.println("Optimal:"+s.threeSumClosestOptimal(arr, 1));     
    }
}
