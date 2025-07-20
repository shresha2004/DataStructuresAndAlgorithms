package BinarySearch;
//Problem:https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence

class Solution {
    int countFreqMyBruteForce(int[] arr, int target) {
        // code here
        int n = arr.length;
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i] == target) count++;
        }
        return count;
    }

    int countFreqMyOptimal(int[] arr, int target) {
        // code here
        int n = arr.length;
        int count = 0;
       
        
        int start = lowerBound(arr,target,n);
        int end = upperBound(arr,target,n);
        if (start == -1) return 0;
         
        count = end - start + 1; 
        return count;
    }
    
    private int lowerBound(int arr[], int target, int n){
        int low = 0;
        int high = n-1;
        int start = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(target == arr[mid]){
                start = mid;
                high = mid-1;
            }
            else if ( target > arr[mid]) low = mid + 1;
            else high = mid -1;
        }
        return start ;
    }
    
    private int upperBound(int arr[], int target,int n){
        int low = 0;
        int high = n-1;
        int end = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(target == arr[mid]){
                end = mid;
                low = mid+1;
            }
            else if (target < arr[mid]){
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
        }
        return end;
    }
}


public class Problem7 {
public static void main(String[] args){
  Solution s = new Solution();
  int[] arr = {1, 1, 2, 2, 2, 2, 3};
  int  target = 2  ;
  System.out.println("My Brute Force:"+s.countFreqMyBruteForce(arr, target));
  System.out.println("My Optimal:"+s.countFreqMyOptimal(arr, target));
}
}
