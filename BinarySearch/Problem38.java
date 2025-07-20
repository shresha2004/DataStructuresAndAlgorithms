//Problem:https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s
package BinarySearch;

class Solution {
    public int rowWithMax1sBruteForce(int arr[][]) {
        // code here
        int  m = arr.length;
        int n = arr[0].length;
        int maxCount = -1;
        int index = -1;
        
        for(int i =0;i<m;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[i][j]==1) count++;
            }
          if(count > maxCount && count !=0){  index = i;
          maxCount = count;
        }
        }
        return index;
    }

    public int rowWithMax1sOptimal(int arr[][]) {
        // code here
        int  m = arr.length;
        int n = arr[0].length;
        int maxCount = -1;
        int maxIndex = -1;
        
        for(int i =0;i<m;i++){
           int low = 0;
           int count = 0;
           int high = arr[i].length-1;
           while(low <= high){
               int mid = (low+high) >> 1;
               if(arr[i][mid] == 0){
                   low=mid+1;
               }else{
                   count = n-mid;
                   high=mid-1;
               }
           }
         if(count > maxCount){
             maxCount = count;
             maxIndex = i;
         }
        }
        return maxIndex;
        }
}

public class Problem38 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
        System.out.println("My Brute Force:"+s.rowWithMax1sBruteForce(arr));
        System.out.println("My Optimal:"+s.rowWithMax1sOptimal(arr));

    }
}
