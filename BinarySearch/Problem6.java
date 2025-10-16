
//Problem:https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
import java.util.Arrays;
class Solution {
    public int[] searchRangeMyBruteForce(int[] nums, int target) {
        int n = nums.length;
        int flag =0;
        int start = -1;
        int end = -1;
        int[] ans = new int[2];

        for(int i =0; i<n; i++){
            if(nums[i]==target && flag==0){
                start = i;
                flag = 1;
            }
            if(nums[i] == target && i== n-1){
                end = i;
                break;
            }
            if(nums[i] != target && flag==1){
                end = i-1;
                break;
            }
        }
        ans[0] = start;
        ans[1] = end;

        return ans;
        
    }

    //BinarySearch
    public int[] searchRangeOptimal(int[] nums, int target) {
        int n = nums.length;
       int start = lowerBound(nums, target, n);
       if(start == -1) return new int[] {-1,-1};
       int end = upperBound(nums,target, n);
   
       return new int[] {start,end}; 
    }


    private int lowerBound(int[] nums, int target, int n){
       int low = 0;
       int high = n-1;
       int start = -1;
       while(low<= high){
        int mid = (low+high)/2;
        if(nums[mid] == target){
            start = mid;
            high = mid-1;
        }
        else if (target < nums[mid]){
            high = mid -1;

        }
        else low = mid +1;
       }

       return start;
    }

    private int upperBound(int[] nums, int target, int n){
        int low =0;
        int high = n-1;
        int end = -1;

        while(low <= high){
            int mid = (low+high)/2;
            if(target == nums[mid]){
                end = mid;
                low = mid+1;
            }
            else if ( target < nums[mid]) high = mid-1;
            else low = mid+1;

        }
        return end;
    }
}
public class Problem6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println("My Bruteforce:"+ Arrays.toString(s.searchRangeMyBruteForce(nums, target)));
        System.out.println("Optimal:"+ Arrays.toString(s.searchRangeOptimal(nums, target)));
    }
    
}
