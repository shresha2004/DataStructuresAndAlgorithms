package BinarySearch;

import java.util.Arrays;

//Problem:https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=ceil-the-floor
class Solution {
    //BruteForce
    public int[] getFloorAndCeilMyBruteForce(int x, int[] arr) {
        // code here
        int n = arr.length;
        int[] ans = new int[2];
        int floor = -1;
        int ceil = -1;
        int flag = 0;
        
        int checkFloor = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++){
            if(arr[i]<=x && arr[i]> checkFloor){
                checkFloor=arr[i];
                flag=1;
            }
        }
        if(flag == 1)
        floor = checkFloor;
        
        
       int checkCeil = Integer.MAX_VALUE;
        flag = 0;
        for(int i=0; i<n; i++){
            if(arr[i]>=x && arr[i]<checkCeil){
                checkCeil=arr[i];
                flag=1;
            }
        }
        if(flag == 1)
        ceil =  checkCeil;
        
        
        ans[0] = floor;
        ans[1] = ceil;
        
        return ans;
        
    }

    //Optimal (When sorting time complexity is not considered)
    public int[] getFloorAndCeilMyOptimal(int x, int[] arr) {
        // code here
     int n = arr.length;
     int[] sortedArr = new int[n];
     sortedArr = sort(arr,n);
     int[] ans = new int[2];
     int low = 0;
     int high = n-1;
     int floor = -1;
     int ceil = -1;
     int checkFloor = Integer.MIN_VALUE;
     int checkCeil = Integer.MAX_VALUE;
     int flagCeil = 0;
     int flagFloor = 0;
    
     while(low <= high){
         int mid = (low + high)/2;
         
         if(x < sortedArr[mid]){
             high = mid-1;
             if(sortedArr[mid] >= x && sortedArr[mid] < checkCeil){
                 checkCeil = sortedArr[mid];
                 flagCeil =1;
             }
             
         }
         
         if(x > sortedArr[mid] ){
             low = mid+1;
             if(sortedArr[mid] < x && sortedArr[mid] > checkFloor ){
                 checkFloor = sortedArr[mid];
                 flagFloor=1;
             }
         }
         
         if ( x == sortedArr[mid]) return new int[] {sortedArr[mid] , sortedArr[mid] };
        
        
        
    }
    if (flagFloor == 1){
        floor = checkFloor;
    }
    if(flagCeil == 1){
        ceil = checkCeil;
    }
    ans[0] = floor;
    ans[1] = ceil;
    return ans;
}
    
    private int[] sort(int[] arr, int n){
        
        boolean swapped;
        for(int i=n-1; i<=1 ; i--){
            swapped=false;
            for(int j=0; j<i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
                if(swapped == false) break;
            }
            
            
        }
      return arr;  
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr={5, 6, 8, 8, 6, 5, 5, 6};
        int x = 10;
        System.out.println("My BruteForce:"+ Arrays.toString(s.getFloorAndCeilMyBruteForce(x,arr)));
        System.out.println("My BruteForce:"+ Arrays.toString(s.getFloorAndCeilMyOptimal(x,arr)));
 
    }
}
