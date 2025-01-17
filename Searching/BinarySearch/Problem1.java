package BinarySearch;

class Solution {
    public int searchBruteForce(int[] nums, int target) {
        int n = nums.length;
        for(int i =0; i<n ;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    //Binary Search Algorithm
    public int searchoptimal(int[] nums, int target) {
        int n = nums.length;
        int low =0;
        int high = n-1;
       while(low <= high){
        int mid = (low+high)/2;
        if(target<nums[mid]) high=mid-1;
        else if (target>nums[mid]) low=mid+1;
        else return mid;

       }
        return -1;
    }
}

public class Problem1 {
    public static void main(String args[]){
        int[] nums={-1,0,3,5,9,12};
        int target = 9;
        Solution s= new Solution();
        System.out.println("BruteForce:"+ s.searchBruteForce(nums, target));
        System.out.println("Optimal:"+ s.searchoptimal(nums, target));

    }
}
