//Problem:https://leetcode.com/problems/merge-sorted-array/description/
import java.util.Arrays;
class Solution {
    public int[] mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
       int ans[] = new int[m+n];
       int i=0;
       int j=0;
       int k=0;
       while(i<m && j<n){
        if(nums1[i]<nums2[j]){
            ans[k]=nums1[i];
            i++;
            k++;
        }else{
            ans[k]=nums2[j];
            j++;
            k++;
        }
       }
       while(i<m){
        ans[k++]=nums1[i];
        i++;
       }
       while(j<n){
        ans[k++]=nums2[j];
        j++;
       }
       for(int q=0;q<(m+n);q++){
        nums1[q]=ans[q];
       }
       return nums1;
}
}
public class Problem39 {
    public static void main(String[] args) {
        Solution s=new Solution();
      int[]  nums1 = {1,2,3,0,0,0};
      int m = 3;
      int[]  nums2 = {2,5,6};
      int n = 3;
            System.out.println("Brute Force Approach:"+Arrays.toString( s.mergeBruteForce(nums1,m,nums2,n)));
           // System.out.println("Brute Force Approach:"+Arrays.deepToString( s.mergeOptimal()));
    }
}
