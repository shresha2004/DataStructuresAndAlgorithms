//Problem:https://leetcode.com/problems/sort-colors/description/
import java.util.Arrays;
class Solution {
    public int[] sortColors(int[] nums) {
        int n =nums.length;
        for(int i=0;i<n-1;i++){
           int min=i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
               
            }
             if(min!=i){
                int temp = nums[min];
                nums[min]=nums[i];
                nums[i]=temp;
            }
        }
        return nums;
    }
}
public class Problem13 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums ={2,0,2,1,1,0};
        System.out.println(Arrays.toString(s.sortColors(nums)));
    }
}
