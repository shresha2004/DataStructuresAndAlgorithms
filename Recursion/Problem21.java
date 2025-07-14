//Problem:https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cand = new ArrayList<>();
        backTrack(ans,cand,candidates,target,0,0);
        return ans;
    }
    private void backTrack(List<List<Integer>> ans,List<Integer> cand,int[] candidates,int target,int sum,int index){
        if(sum > target) return;
        if(index == candidates.length){
            if(sum == target) ans.add(new ArrayList<>(cand));
            return;
        }
        cand.add(candidates[index]);
        backTrack(ans,cand,candidates,target,sum+candidates[index],index);
        cand.remove(cand.size()-1);
        backTrack(ans,cand,candidates,target,sum,index+1);

    return;
    }
}
public class Problem21 {
    public static void main(String[] args) {
        int[] arr ={ 2,3,6,7};
        int target = 7;
        Solution s = new Solution();
        System.out.println("Recursive:"+s.combinationSum(arr, target));
    }
}
