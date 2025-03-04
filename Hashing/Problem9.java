//Problem:https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=problem-list-v2&envId=hash-table
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int num : nums1) set1.add(num);
        for(int num : nums2) set2.add(num);
        for(int num : set1) if(!set2.contains(num)) ans1.add(num);
        for(int num : set2) if(!set1.contains(num)) ans2.add(num);
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}
public class Problem9 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println("Brute Force:"+s.findDifference(nums1, nums2));
    }
}
