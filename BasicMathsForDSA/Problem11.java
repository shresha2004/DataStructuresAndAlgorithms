//Problem:https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
    public int differenceOfSum(int[] nums) {
        int elementSum = eleSum(nums);
        int digitSum = digSum(nums);
        return Math.abs(elementSum - digitSum);
    }
    public int eleSum(int[] nums){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }
    public int digSum(int[] nums){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            while(num > 0){
                int number = num % 10;
                sum += number;
                num = num/10;
            }
        }
        return sum;
    }
}
public class Problem11 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums ={1,15,6,3} ;
        System.out.println("Brute Force:"+s.differenceOfSum(nums));
       // System.out.println("Optimal:"+s.);
    }
}
