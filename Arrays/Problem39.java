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
//Gap method (Shell sort)
public int[] mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
    int len = m + n;
    int gap = (len / 2) + (len % 2);

    while (gap > 0) {
        int left = 0;
        int right = left + gap;

        while (right < len) {
         
            if (left < m && right < m) {
                if (nums1[left] > nums1[right]) {
                    swap(nums1, left, nums1, right);
                }
            }
            else if (left < m && right >= m) {
                if (nums1[left] > nums2[right - m]) {
                    swap(nums1, left, nums2, right - m);
                }
            }
            else if (left >= m && right >= m) {
                if (nums2[left - m] > nums2[right - m]) {
                    swap(nums2, left - m, nums2, right - m);
                }
            }
            left++;
            right++;
        }

        if (gap == 1) break;
        gap = (gap / 2) + (gap % 2);
    }

    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }
    return nums1;
}

private void swap(int[] arr1, int idx1, int[] arr2, int idx2) {
    int temp = arr1[idx1];
    arr1[idx1] = arr2[idx2];
    arr2[idx2] = temp;
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
          System.out.println("Brute Force Approach:"+Arrays.toString( s.mergeOptimal(nums1,m,nums2,n)));
    }
}
