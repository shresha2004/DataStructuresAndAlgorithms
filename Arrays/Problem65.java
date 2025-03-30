//Problem:https://leetcode.com/problems/maximum-gap/description/?envType=problem-list-v2&envId=array

class Solution{
    public int maximumGapBruteForce(int[] nums) {
        if(nums.length < 2) return 0;
        quickSort(nums,0,nums.length-1);
        int maxDiff = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int j = i+1;
            int diff  = nums[j] - nums[i];
            maxDiff = Math.max(maxDiff,diff);
        }
        return maxDiff;
    }
    private void quickSort(int[] nums,int low,int high){
        if(low < high){
            int p = partition(nums,low,high);
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);

        }
    }
    private int  partition(int[] nums,int low,int high ){
       int pivot = low;
        int i=low;
        int j= high;
        while(i<j){
            while(i<=high && nums[i] <= nums[pivot] ) i++;
            while(j>low && nums[j]>nums[pivot]) j--;

            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }
}
public class Problem65 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3,6,9,1};
        System.out.println("Brute Force:"+s.maximumGapBruteForce(arr));
        //System.out.println("Optimal:"+s.);
    }
}
