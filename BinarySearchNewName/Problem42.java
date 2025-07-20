//Problem:https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-in-a-row-wise-sorted-matrix
package BinarySearch;
import java.util.ArrayList;
class Solution {
    int medianBruteForce(int mat[][]) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int[] arr = new int[m*n];
        int index=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               arr[index++] =mat[i][j];
                
            }
        }
        mergeSort(arr,0,arr.length-1);
        return arr[(arr.length/2)];
    }
    
    private void mergeSort(int[] arr,int low,int high){
        if(high<=low) return;
        int mid = (low+high) >> 1;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    
    private void merge(int[] arr,int low, int mid,int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(left <= mid && right <= high){
            if(arr[left]<arr[right]){
                temp.add(arr[left++]);
            } else{
                temp.add(arr[right++]);
            }
        }
        
        while(left <= mid){
            temp.add(arr[left++]);
        }
        while(right <= high){
            temp.add(arr[right++]);
        }
        
        int i=low;
        for(int j=0;j<temp.size();j++){
            arr[i]=temp.get(j);
            i++;
        }
    }

    int medianOptimal(int mat[][]) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            low = Math.min(low,mat[i][0]);
            high = Math.max(high,mat[i][n-1]);
        }
        
        int req = (m*n)/2;
        while(low <= high){
            int mid = (low+high)>>1;
            int smaller =blackBox(mat,mid,m);
            if(smaller <= req){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }
    
    private int blackBox(int[][] mat,int x,int m){
        int count=0;
        for(int i=0;i<m;i++){
            count+=smallInRow(mat[i],x);
        }
        return count;
    }
    
    private int smallInRow(int[] row,int x){
        int low =0;
        int high = row.length-1;
        int ans =row.length;
        while(low <= high){
            int mid = (low+high)/2;
            if(row[mid]>x){
                ans =mid;
                high =mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
public class Problem42 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println("Brute Force:"+s.medianBruteForce(mat));
        System.out.println("Optimal:"+s.medianOptimal(mat));
    }
}
