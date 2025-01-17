package BinarySearch;
//Problem:https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array
class Solution{
    static int findFloorBruteForce(int[] arr, int k) {
        
        int n=arr.length;
        int largeEle = Integer.MIN_VALUE;
        int index = -1 ;
       for(int i=0; i<n ; i++){
           if(arr[i]<=k && arr[i]>largeEle){
                    largeEle = arr[i];
                    index=i;
           }
       }
       return index;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr={1, 2, 8, 10, 11, 12, 19};
        System.out.println("BruteForce:"+s.findFloorBruteForce(arr, 5));
        
    }
}
