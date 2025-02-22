//Problem:https://leetcode.com/problems/sort-array-by-parity/description/?envType=problem-list-v2&envId=sorting
//I selected question
import java.util.Arrays;
class Solution {
    public int[] sortArrayByParityBruteForce(int[] nums) {
        
        int n = nums.length;
        for(int i =0; i<n-1;i++){
            int ele = nums[i];
            if(ele %2 !=0){
            for(int j=i+1;j<n;j++){
                if(nums[j]%2==0){
                    int temp = nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }
            }
        }
        return nums;
    }
}
public class Problem56 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,1,2,4};
        System.out.println("My Brute Force:"+Arrays.toString(s.sortArrayByParityBruteForce(nums)));
      //  System.out.println("Optimal:"+s.isValidBruteForce("(){}[]"));
    }
}
