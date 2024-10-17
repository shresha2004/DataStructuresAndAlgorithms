//Problem:https://leetcode.com/problems/majority-element/description/?envType=problem-list-v2&envId=hash-table&difficulty=EASY
import java.util.HashMap;
class Solution {
    public int majorityElement(int[] nums) {
        int majorityNum=0;
        HashMap<Integer,Integer> hash=new HashMap<>();

        for(int num : nums){
            hash.put(num,hash.getOrDefault(num,0)+1);

            if(hash.get(num)>(nums.length/2)){
                majorityNum=num;
            }
        }
        return majorityNum;
    }
}
public class Problem8 {
    public static void main(String[] args) {
     Solution s=new Solution();
     int[] nums=  {2,2,1,1,1,2,2};
     System.out.println(s.majorityElement(nums))  ;  
    }
    
}
