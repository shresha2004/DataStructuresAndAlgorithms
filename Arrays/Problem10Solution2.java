import java.util.HashMap;
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        int n=nums.length;
       int result=0;
       for(int num : nums){
        result ^= num;
       }
        
       return result; 
    }
}
public class Problem10Solution2 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums = {4,1,2,1,2};
        System.out.println(s.singleNumber(nums));
    }
    
}
