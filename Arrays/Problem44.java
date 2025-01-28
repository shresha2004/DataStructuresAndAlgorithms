//Problem:https://leetcode.com/problems/intersection-of-two-arrays/description/?envType=problem-list-v2&envId=array
//I choosed

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    public int[] intersectionBruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Set<Integer> s = new HashSet<>();

        for(int i=0; i<n1; i++){
           
            for(int j=0; j<n2; j++){
                if(nums1[i] == nums2[j] ){
                    s.add(nums1[i]);
                }
            }
        }
        List<Integer> ls = new ArrayList<>(s);
        int[] ans = new int[s.size()];

        for(int i = 0; i< s.size();i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
    public int[] intersectionBetter(int[] nums1, int[] nums2) {
        
       HashSet<Integer> arr = new HashSet<>();
       HashSet<Integer> ans = new HashSet<>();

       for(int num : nums1){
        arr.add(num);
       }
       for(int num : nums2){
        if(arr.contains(num)){
            ans.add(num);
        }
       }
        int[] ansArr = new int[ans.size()];
        int i=0;
        for(int num : ans){
            ansArr[i++] = num;
        }
       return ansArr;
    }
}

public class Problem44 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums1 = {1,2,2,1};
        int[]  nums2 = {2,2};
        System.out.println("Brute Force:"+Arrays.toString(s.intersectionBruteForce(nums1, nums2)));
        System.out.println("Better:"+Arrays.toString(s.intersectionBetter(nums1, nums2)));
    }
}
