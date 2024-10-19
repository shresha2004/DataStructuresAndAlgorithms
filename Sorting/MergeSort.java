import java.util.ArrayList;
import java.util.Arrays;
class Solution
{
    int[] merge(int arr[], int l, int m, int r)
    {
        
         // Your code here
         ArrayList<Integer> temp = new ArrayList<>();
         int left=l;
         int right=m+1;
         while(left<=m && right<=r ){
             if(arr[left]<=arr[right]){
                  temp.add(arr[left]);
                 left++;
                
             }
             else{
                 temp.add(arr[right]);
                 right++;
             }
         }
         
         while(left<=m){
             temp.add(arr[left]);
             left++;
         }
         while(right<=r){
             temp.add(arr[right]);
             right++;
         }
         for (int i = 0; i < temp.size(); i++) {
            arr[l + i] = temp.get(i);
        }
         return arr;
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l==r) return;
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        System.out.println(Arrays.toString(merge(arr,l,mid,r)));
    }
}

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Solution s=new Solution();
        s.mergeSort(arr,0,9);
    }
    
}
