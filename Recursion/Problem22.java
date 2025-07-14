//Problem:https://leetcode.com/problems/combination-sum-ii/description/

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cand = new ArrayList<>();
        quickSort(candidates, 0, candidates.length - 1);
        backTrack(ans, cand, candidates, target, 0, 0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> cand, int[] candidates, int target, int index,
            int sum) {
       
        if (sum == target) {
            ans.add(new ArrayList<>(cand));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (sum+candidates[i] > target)
                break;

            cand.add(candidates[i]);
            backTrack(ans, cand, candidates, target, i + 1, sum + candidates[i]);
            cand.remove(cand.size() - 1);
        }
        return;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int p = partiton(nums, start, end);
            quickSort(nums, start, p - 1);
            quickSort(nums, p + 1, end);
        }

    }

    private int partiton(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= end && nums[i] <= pivot)
                i++;
            while (j >= start && nums[j] > pivot)
                j--;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[j];
        nums[j] = nums[start];
        nums[start] = temp;
        return j;
    }
}
public class Problem22 {
    public static void main(String[] args) {
        int[] arr ={10,1,2,7,6,1,5};
        int target = 8;
        Solution s = new Solution();
        System.out.println("Recursion"+s.combinationSum2(arr, target));
    }
}
