import java.util.HashMap;
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        int n=nums.length;
        int onlyOne=nums.length;
        for(int num: nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        System.out.println(hash);
        for(int i=0;i<n;i++){
            if(hash.get(nums[i])==1){
                onlyOne=nums[i];
                break;
            }
        }
        
       return onlyOne; 
    }
}
public class Problem10 {
public static void main(String[] args) {
    Solution s=new Solution();
        int[] nums = {4,1,2,1,2};
        System.out.println(s.singleNumber(nums));
    
}
}
