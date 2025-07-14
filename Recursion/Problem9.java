//Problem:https://leetcode.com/problems/subsets/
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int index=0;
    
    public List<List<Integer>> subset= new ArrayList<>();

     public List<List<Integer>> subsetsRecursion(int[] nums) {
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
     public List<List<Integer>> subsetsBitManipulation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = nums.length;
        for(int num=0;num<(1<<n);num++){
        List<Integer> set = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num &(1<<i))!=0) set.add(nums[i]);
            }
            if(set.size()>0) ans.add(set);
        }
       ans.add(new ArrayList<>());
        return ans;
    }
     }
public class Problem9 {
    public static void main(String[] args) {
     Solution s=new Solution();
     int[] num={3,1,2};
    System.out.println("Using Recursion:"+s.subsetsRecursion(num));
    System.out.println("Using Bitmanipulation:"+s.subsetsBitManipulation(num));
    }
    
}
