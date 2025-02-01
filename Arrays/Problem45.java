//Problem:https://leetcode.com/problems/squares-of-a-sorted-array/description/

import java.util.Arrays;

class Solution {
    public int[] sortedSquaresBruteForce(int[] nums) {
        int n = nums.length;
        int[] sqrArray = new int[n];
        for(int i =0; i<n;i++){
            int sqr = nums[i] * nums[i];
            sqrArray[i] = sqr;
        }
        for(int i =0; i<n;i++){
            int min =i;
            for(int j =i;j<n;j++){
                if(sqrArray[j] < sqrArray[min]){
                    min = j;
                }
            }
            if(min !=i){
                int temp = sqrArray[min];
                    sqrArray[min] = sqrArray[i];
                    sqrArray[i] = temp;
            }
        }
        return sqrArray;
    }
}
public class Problem45 {
     public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {-4,-1,0,3,10};
       
        System.out.println("Brute Force:"+Arrays.toString(s.sortedSquaresBruteForce(nums)));
    }
}
