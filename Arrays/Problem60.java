import java.util.Arrays;
class Solution {
    public int[] sortArrayByParityIIBruteForce(int[] nums) {
        int n = nums.length;
        
        int[] ans = new int[n];
        int evenIndex = 0;
        int oddIndex = 1;
       for(int num : nums){
        if(num % 2 == 0){
            ans[evenIndex] = num;
            evenIndex+=2;
        }
        else{
            ans[oddIndex] = num;
            oddIndex+=2;
        }
       }
        return ans;
        
    }
}
public class Problem60 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,2,5,7};
        System.out.println("Brute Force:"+Arrays.toString(s.sortArrayByParityIIBruteForce( nums)));
        System.out.println("Optimal:"+Arrays.toString(s.sortArrayByParityIIBruteForce( nums)));
    }
}
