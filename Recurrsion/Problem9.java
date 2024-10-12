//Problem:https://leetcode.com/problems/subsets/
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int index=0;
    
    public List<List<Integer>> subset= new ArrayList<>();

     public List<List<Integer>> subsets(int[] nums) {
        f(0,new ArrayList<Integer>(),nums);
            return subset; 
         }
 
     public void f(int index,ArrayList<Integer> arr,int[] nums){
         if(index>=nums.length){
             subset.add(new ArrayList<>(arr));
             return;
         }
         arr.add(nums[index]);
         f(index+1,arr,nums);
         arr.remove(arr.size()-1);
         f(index+1,arr,nums);
     }
     }
public class Problem9 {
    public static void main(String[] args) {
     Solution s=new Solution();
     int[] num={3,1,2};
    System.out.println(s.subsets(num)); 
    }
    
}
