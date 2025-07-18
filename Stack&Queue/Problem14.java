//Problem:https://leetcode.com/problems/next-greater-element-i/description/
import java.util.*;
class Solution {
    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<nums1.length;i++){
            int ele = nums1[i];
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==ele){
                    boolean flag = false;
                    for(int k=j+1;k<nums2.length;k++){
                        
                        if(nums2[k]>ele){
                            flag = true;
                            arr.add(nums2[k]);
                            break;
                        }
                    }
                    if(flag== false) arr.add(-1);
                    else break;
                }
            }
        }
        int[] ans = new int[arr.size()];
        int i =0;
     for (int ele : arr){
        ans[i++]=ele;
     }
     return ans;
    }
}
public class Problem14 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        System.out.println("My Bruteforce:"+Arrays.toString(s.nextGreaterElementBruteForce(nums1, nums2)));
    }
}
