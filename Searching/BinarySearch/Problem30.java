package BinarySearch;
import java.util.ArrayList;
class Solution {
    public int findTheDistanceValueBruteForce(int[] arr1, int[] arr2, int d) {
        int n1= arr1.length;
        int n2 = arr2.length;
        int count = 0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                int check = Math.abs(arr1[i]-arr2[j]);
                if(check <= d){ 
                    
                    break;
                }
                else if(j==n2-1) count++;
            }
        }
        return count;
        
    }


    public int findTheDistanceValueOptimal(int[] arr1, int[] arr2, int d) {
        int n1= arr1.length;
        int n2 = arr2.length;
        int count = 0;

        mergeSort(arr2,0,n2-1);
        
        for(int x : arr1){
            if(binarySearch(0,n2-1,arr2,d,x)){
                count++;
            }
        }
        return count;
        
    }
    private boolean binarySearch(int low,int high, int[] nums,int d,int x){
        while(low <= high){
            int mid = (low+high)/2;
            int check = Math.abs(x-nums[mid]);
            if(check <= d) return false;
           if(nums[mid]<x) low = mid+1;
           else high = mid-1;
        }
      
        return true;
    }

    private void mergeSort(int[] nums,int low,int high){
        if(high<=low) return;
        int mid = (low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);

    }

    private void merge(int[] nums,int low,int mid,int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <=mid && right <= high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else {
                temp.add(nums[right]);
                right++;
            }

        }
        while(left <= mid){
            temp.add(nums[left++]);
    }
        while(right <= high){
            temp.add(nums[right++]);
        }
        int i =low;
        for(int num : temp){
            nums[i++] = num;
        }
    }
}
public class Problem30 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int[]  arr1 = {1,4,2,3};
      int[] arr2 = {-4,-3,6,10,20,30};
      int d = 3;
        System.out.println("Brute Force:"+s.findTheDistanceValueBruteForce(arr1,arr2,d));
        System.out.println("Optimal:"+s.findTheDistanceValueOptimal(arr1,arr2,d));
    }
}
