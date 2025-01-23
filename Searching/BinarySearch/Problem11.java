package BinarySearch;
import java.util.ArrayList;
import java.util.List;
//Problem:https://www.geeksforgeeks.org/problems/rotation4723/1?utm_source=youtube

class Solution {
    public int findKRotationBruteForce(List<Integer> arr) {
        // Code here
        int n = arr.size();
        int min = arr.get(0);
        int index = 0;
        for(int i = 1; i<n;i++){
            if(arr.get(i)< min){
                min = arr.get(i);
                index = i;
            }
        }
        return index;
    }
    
    public int findKRotationOptimal(List<Integer> arr) {
        // Code here
        int n = arr.size();
        int min =Integer.MAX_VALUE;
        int index = 0;
        int low = 0;
        int high = n-1;
        
        //BinarySearch
        while(low<= high){
            int mid = (low+high)/2;
            
            if(arr.get(mid) >= arr.get(low)){
                min = Math.min(min,arr.get(low));
                index = arr.indexOf(min);
                low = mid+1;
            }
            else if(arr.get(mid) <= arr.get(high)){
                min = Math.min(min,arr.get(mid));
                index = arr.indexOf(min);
                high = mid-1;
            }
        }
        
        return index;
    }
}



public class Problem11 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5, 1, 2, 3, 4};
        List<Integer> ls = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++) ls.add(arr[i]);
        System.out.println("Brute Force:"+s.findKRotationBruteForce(ls));
        System.out.println("Optimal:"+s.findKRotationBruteForce(ls));

    }
}
