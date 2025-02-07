package BinarySearch;

import java.util.ArrayList;

//Problem:https://www.spoj.com/problems/AGGRCOW/
class Solution{
    public int aggressiveCowsBruteForce(int stalls[], int cows){
        mergeSort(stalls, 0, 5);
        int n = stalls.length;
        int min = stalls[0];
        int max = stalls[n-1];
         int limit = max -min;
        for(int i=0;i<(max-min);i++){
            if(canWePlace(stalls,i,cows,n)== false) return i-1;
           
        }

        return limit;
    }
    public int aggressiveCowsOptimal(int stalls[], int cows){
        mergeSort(stalls, 0, 5);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        while(low <= high){
            int mid = (low+high)/2;
            if(canWePlace(stalls, mid, cows, n)==true) high = mid-1;
            else if(canWePlace(stalls, mid, cows, n)==false) low = mid+1;
        }
        return high;
    }

    private boolean canWePlace(int stalls[],int i,int cows, int n){
        int count =1;
        int last = stalls[0];
        for(int j=1;j<n;j++){
            if((stalls[j]-last) >= i){
                count++;
                last = stalls[j];
            }
        }
        if(count >= cows) return true;
        return false;
    }

    private void mergeSort(int[] arr,int low,int high){
        if(high <= low) return;
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
           }

    private void merge(int[] arr,int low,int mid, int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();

        while(left<= mid && right <= high){
            if(arr[right] <= arr[left]){
                temp.add(arr[right]);
                right++;
            }else{
                temp.add(arr[left]);
                left++;
            }
        }

        while(left <= mid){
            temp.add(arr[left++]);
        }
        while(right <= high){
            temp.add(arr[right++]);
        }
        
      
        int i = low;
        for(int num : temp){
            arr[i++] = num;
        }
       
    }
}
public class Problem25 {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] stalls = {0,3,4,10,9,7};
        int cows = 4;
        System.out.println(s.aggressiveCowsBruteForce(stalls, cows));

    }
}
