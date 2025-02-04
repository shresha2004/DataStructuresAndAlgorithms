package BinarySearch;
//Problem:https://leetcode.com/problems/kth-missing-positive-number/description/

class Solution {
    public int findKthPositiveMyBruteForce(int[] arr, int k) {
        int n= arr.length;
        int count  = 0;
        int j = 0;
        int i =0;
        while(count <= k){
            j++;
            if(i<n){
                if(arr[i] != j ){
                    count++;
                }
                else{
                    i++;
                }
            } else{
                i++;
            }  
                if(i>n) count++;
                if(count>= k) return j;
            
        }
       return 0;
        
    }
    public int findKthPositiveBruteForce(int[] arr, int k) {
        int n= arr.length;
        for(int i = 0;i<n;i++){
            if(arr[i] <= k) k++;
            else break;
        }
        return k;
    }
    public int findKthPositiveOptimal(int[] arr, int k) {
        int n= arr.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            int missingNum = arr[mid] - (mid+1);
            if(missingNum < k) low = mid+1;
            else high = mid-1;
        }
       return k+high+1;
    }
}
public class Problem22 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] arr = {2,3,4,7,11};
       int k = 5;
        System.out.println("Brute Force:"+s.findKthPositiveMyBruteForce(arr, k));
        System.out.println("Brute Force:"+s.findKthPositiveBruteForce(arr, k));
        System.out.println("Brute Force:"+s.findKthPositiveOptimal(arr, k));
    }
}
