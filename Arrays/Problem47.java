//Problem:https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] intersectBruteForce(int[] nums1, int[] nums2) {
        int n1 =  nums1.length;
        int n2 = nums2.length;
        mergeSort(nums1,0,n1-1);
        mergeSort(nums2,0,n2-1);
        int left = 0;
        int right = 0;
        List<Integer> arr = new ArrayList<>();
        while(left < n1 && right < n2){
            if(nums1[left] == nums2[right]){
                arr.add(nums1[left]);
                left++;
                right++;
            }
            else if(nums1[left]< nums2[right]){
                left++;
            }
            else right++;
        }
        int[] ansArr = new int[arr.size()];
        int index = 0;
        for(int num : arr){
            ansArr[index] = num;
            index++;
        }
        return ansArr;
    }

    private void mergeSort(int[] nums,int low,int high){
        if(low >= high) return;
        int mid = (low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    private void merge(int[] nums,int low,int mid, int high){
        int left = low;
        int right = mid+1;
        List<Integer> arr = new ArrayList<>();

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                arr.add(nums[left]);
                left++;
            }
            else {
                arr.add(nums[right]);
                right++;
            }
        }
       for(int i = left; i <= mid; i++){
            arr.add(nums[i]);
       }
       for(int i = right; i <= high; i++){
            arr.add(nums[i]);
       }
       int j =0;
       for(int i = low;i<=high;i++){
        nums[i] = arr.get(j);
        j++;
       }
    }

    public int[] intersectOptimal(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
 
        for(int num : nums1){
         map.put(num,map.getOrDefault(num,0)+1);
        }
 
        for(int num : nums2){
         if(map.getOrDefault(num,0) > 0){
             arr.add(num);
             map.put(num,map.get(num)-1);
         }
        }
        return arr.stream().mapToInt(i -> i).toArray();
     }
}
public class Problem47 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println("Brute Force:"+Arrays.toString(s.intersectBruteForce(nums1,nums2)));
        System.out.println("Optimal:"+Arrays.toString(s.intersectOptimal(nums1,nums2)));
    }
}
