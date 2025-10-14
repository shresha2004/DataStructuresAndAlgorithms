//Problem:https://leetcode.com/problems/permutations/
import java.util.*;
class Solution{
public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Boolean[] used  = new Boolean[nums.length];
        Arrays.fill(used,false);
        f(nums,ans,cur,used);
        return ans;
    }
    private void f(int[] nums, List<List<Integer>> ans,List<Integer> cur,Boolean[] used){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
             return ;
        }
        for(int i=0;i<nums.length;i++){
        if(used[i]) continue;
        used[i]=true;
        cur.add(nums[i]);
        f(nums,ans,cur,used);
        cur.remove(cur.size()-1);
        used[i]=false;
       
        }
        return ;
    }
}
public class Problem35 {
    public static void main(String[] args) {
        int[] arr ={1,2,3};
        Solution s = new Solution();
        System.out.println("Optimal:"+s.permute(arr));
    }
}
