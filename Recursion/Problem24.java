//Problem:https://leetcode.com/problems/subsets-ii/description/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> check = new ArrayList<>();
        mergeSort(nums, 0, nums.length - 1);
        backtrack(ans, check, nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> check, int[] nums, int index) {   

            ans.add(new ArrayList<>(check));      
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            check.add(nums[i]);
            backtrack(ans, check, nums, i+1);
            check.remove(check.size() - 1);
        }

        return;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= high) {
            temp.add(nums[right++]);
        }
        int i = low;
        for (int ele : temp) {
            nums[i++] = ele;
        }
    }
}
public class Problem24 {
    public static void main(String[] args) {
        int[] arr ={1,2,2 };
        Solution s = new Solution();
        System.out.println("Recursive:"+s.subsetsWithDup(arr));
    }
}
