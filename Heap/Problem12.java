//Problem:https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1
import java.util.*;
class Solution {
    static int[] convertMinToMaxHeap(int N, int arr[]) {
        // code here
        for(int i=(N/2)-1;i>=0;i--)
            heapify(i,N,arr);
        return arr;
    }
    static void heapify(int i,int n,int[] arr){
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left < n && arr[left]>arr[largest]){
            largest = left;
        }
        if(right < n && arr[right]>arr[largest]){
            largest = right;
            
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(largest,n,arr);
        }
    }
}

public class Problem12 {
public static void main(String[] args) {
   int N = 4;
    int[] arr = {1, 2, 3, 4};
    Solution s = new Solution();
    System.out.println("Solution:"+Arrays.toString(s.convertMinToMaxHeap(N, arr)));
}
}
