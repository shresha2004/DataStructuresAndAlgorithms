//Problem:https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=inversion-of-array
class Solution {
    // Function to count inversions in the array.
    static int inversionCountBruteForce(int arr[]) {
        // Your Code Here
        int n= arr.length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i]>arr[j] && i<j){
                    count++;
                }
            }
        }
        return count;
    }
    static int inversionCountOptimal(int arr[]) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);        
            count += mergeSort(arr, mid + 1, high);  
            count += merge(arr, low, mid, high);    
        }
        return count;
    }

    static int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1]; 
        int left = low, right = mid + 1, k = 0;
        int count = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                
                count += (mid - left + 1);
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return count;
    }
}
public class Problem41 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] arr = {2, 4, 1, 3, 5};
       System.out.println("Brute Force Approach:"+s.inversionCountBruteForce(arr)); 
      System.out.println("Optimal Approach:"+s.inversionCountOptimal(arr)); 
    }
}
