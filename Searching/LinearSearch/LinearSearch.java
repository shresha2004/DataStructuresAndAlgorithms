package LinearSearch;
//Problem:https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=who-will-win

class Solution {
    static boolean searchInSorted(int arr[], int k) {
       
        for(int i=0;i<arr.length;i++){
            if(arr[i]==k){
                return true;
            }
        }
        return false;
    }
}
public class LinearSearch {
    public static void main(String args[]){
        Solution s=new Solution();
        int[] arr ={1, 2, 3, 4, 6};
        System.out.println(s.searchInSorted(arr,6));
    }
    
    
}
