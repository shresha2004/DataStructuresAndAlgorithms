package BinarySearch;

//Problem:https://leetcode.com/problems/median-of-two-sorted-arrays/description/
class Solution {
    
    public double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] mergedArr = new int[n1+n2];
        int left = 0;
        int right = 0;
        int i = 0;
        while(left < n1 && right < n2){
            if(nums1[left]<nums2[right]){
                mergedArr[i] = nums1[left];
                left++;
            }else {
                mergedArr[i] = nums2[right];
                right++;
            }
            i++;
        }
        while(left < n1){
            mergedArr[i]=nums1[left++];
            i++;
        }
        while(right < n2){
            mergedArr[i]=nums2[right++];
            i++;
        }
        if((n1+n2)%2 !=0) return mergedArr[(n1+n2)/2];
        int index = (n1+n2)/2;
        return (float)(mergedArr[index-1]+mergedArr[index])/2;

        
    }

    public double findMedianSortedArraysBetter(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int index1 = n/2;
        int index2 = index1-1;
       

        int left = 0;
        int right =0 ;
        int count = 0;
        int ele1 = -1;
        int ele2 =-1;
        while(left < n1 && right < n2){
            if(nums1[left]<nums2[right]){
                if(count == index1) ele1 =nums1[left];
                if(count == index2) ele2 = nums1[left];
               left++;
            }
            else {
                if(count == index1) ele1 = nums2[right];
                if(count == index2) ele2 = nums2[right];
                right++;
            }
            count++;
            } 
            while(left < n1){
                 if(count == index1) ele1 = nums1[left];
                if(count == index2) ele2 = nums1[left];
                left++;
                count++;
               
            }
            while(right < n2){
                if(count == index1) ele1 = nums2[right];
                if(count == index2) ele2 = nums2[right];
                right++;
                count++;
                
            }
            if(n%2 !=0) return ele1;
            return (float) (ele1+ele2)/2;

        }


        public double findMedianSortedArraysOptimal(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int n = n1+n2;
            if(n1>n2) return findMedianSortedArraysOptimal(nums2,nums1);
            int low = 0;
            int high = n1;
            int left = (n1+n2+1)/2;
            while(low <= high){
                int mid1 = (low+high)/2;
                int mid2 = left - mid1;
    
                int l1 = (mid1>0) ? nums1[mid1-1] : Integer.MIN_VALUE;
                int l2 = (mid2>0) ? nums2[mid2-1] : Integer.MIN_VALUE;
                int r1 = (mid1<n1) ? nums1[mid1] : Integer.MAX_VALUE;
                int r2 = (mid2<n2) ? nums2[mid2] : Integer.MAX_VALUE;
    
                if(l1<=r2 && l2 <=r1){
                    if(n%2 !=0) return Math.max(l1,l2);
                    else return ((double) (Math.max(l1,l2)+Math.min(r1,r2))/2);
                }
                else if(l1 > r2) high = mid1-1;
                else low = mid1+1;
            }
            return 0;
            }
}

public class Problem36 {
    public static void main(String[] args){
        int[] nums1 = {1,3}, nums2 = {2};
        Solution s = new Solution();
        System.out.println("My Brute Force:"+s.findMedianSortedArraysBruteForce(nums1, nums2));
        System.out.println("Better:"+s.findMedianSortedArraysBetter(nums1, nums2));
        System.out.println("Optimal:"+s.findMedianSortedArraysOptimal(nums1, nums2));

    }
    
}
