//Problem:https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/
import java.util.*;
class Solution {
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        int len = 1;
        for(int i=1;i<n;i++){
            if(arr[i] > ans.get(ans.size()-1)){
                ans.add(arr[i]);
                len++;
            }
            else{
                int ind = binarySearch(ans,arr[i]);
                ans.set(ind,arr[i]);
              

            }
        }
        return len;
    }
    static int binarySearch(ArrayList<Integer> arr,int key){
        int start = 0;
        int end = arr.size()-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr.get(mid)==key) return mid;
            else if(key < arr.get(mid)) end = mid-1;
            else start = mid+1;
        }
        return start;
    }
}
public class Problem43 {
    public static void main(String[] args) {
       int arr[] = {5, 8, 3, 7, 9, 1};
       Solution s = new Solution();
       System.out.println("Binary Search Solution:"+s.lis(arr));
       
    }
}
