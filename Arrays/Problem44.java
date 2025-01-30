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


    public int[] intersectionOptimal(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = 0;
        int right = 0;
        mergeSort(nums1,0,n1-1);
        mergeSort(nums2,0,n2-1);
        HashSet<Integer> set = new HashSet<>();
        System.out.println("Sorted:"+Arrays.toString(nums1)+" "+Arrays.toString(nums2));
 
        while( left<n1 && right<n2){
         if(nums1[left] == nums2[right]){
             set.add(nums1[left]);
             left++;
             right++;
         }
         else if(nums1[left] < nums2[right]){
             left++;
         }
         else right++;
        }
         int[] ansArr = new int[set.size()];
         int i = 0;
         for(int num : set){
             ansArr[i++] = num;
         }
        return ansArr;
     }
 
     private void mergeSort(int[] arr, int low,int high){
         if(low >= high) return;
         int mid = (low+high)/2;
         mergeSort(arr,low,mid);
         mergeSort(arr,mid+1,high);
         merge(arr,low,mid,high);
     }
 
     private void merge(int[] arr,int low,int mid,int high){
         
         int left = low;
         int right = mid+1;
 
         ArrayList<Integer> temp = new ArrayList<>();
         
         while(left <= mid && right<= high){
             if(arr[left] <= arr[right]){
                 temp.add(arr[left]);
                 left++;
             }
             else {
                 temp.add(arr[right]);
                 right++;
             }
         }
          while(left <= mid){
             temp.add(arr[left]);
             left++;
         }
         while(right <= high){
             temp.add(arr[right]);
             right++;
         }
        
 
         for(int i=0; i<temp.size();i++){
             arr[low+i] = temp.get(i);
         }
     }
}

public class Problem44 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums1 = {1,2,2,1};
        int[]  nums2 = {2,2};
        System.out.println("Brute Force:"+Arrays.toString(s.intersectionBruteForce(nums1, nums2)));
        System.out.println("Better:"+Arrays.toString(s.intersectionBetter(nums1, nums2)));
        System.out.println("Optimal:"+Arrays.toString(s.intersectionOptimal(nums1, nums2)));
    }
}
