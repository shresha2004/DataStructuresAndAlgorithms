package BinarySearch;
//Problem:https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
class Solution {
    public int smallestDivisorBruteForce(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            max = Math.max(nums[i],max);
        }

        for(int i = 0; i<=max;i++){
            int sum = divideAndSum(nums,i,n,threshold);
            if(sum > threshold) continue;
            else return i;

        }
        return 0;
    }

    public int smallestDivisorOptimal(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            max = Math.max(nums[i],max);
        }
        int low = 0;
        int high = max;
        while(low <= high){
            int mid = (low + high)/2;
            int sum = divideAndSum(nums,mid,n,threshold);
            if(sum > threshold) low = mid+1;
            else high = mid-1;
           

        }
        return low;
    }

    private int divideAndSum(int[] nums,int i,int n,int threshold){
        int sum = 0;
        for(int j =0;j<n;j++){
            int divide = (int) Math.ceil((double)nums[j]/i);
            sum += divide;
            if(sum > threshold) break;
        }
        return sum;
    }
}

public class Problem20 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int[] nums = {1,2,5,9};
      int threshold = 6;
        System.out.println("My Brute Force:"+s.smallestDivisorBruteForce(nums,threshold));
        System.out.println("My Brute Force:"+s.smallestDivisorOptimal(nums,threshold));
    }
}
