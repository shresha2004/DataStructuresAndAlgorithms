//Problem:https://www.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/0
class Solution {
    public static void frequencyCount(int arr[], int N, int P) {
        int[] hash=new int[P+1];
        
        
        for (int i=0; i<N;i++){
            if(arr[i]<=P){
            hash[arr[i]]=hash[arr[i]]+1;
            }
        }
        
        for(int i=0;i<N;i++){
            if(arr[i]<=P){
            arr[i]=hash[arr[i]];
            }
            System.out.println(arr[i]);
        }
        
    }
}

public class Problem1 {
   public static void main(String args[]){
    Solution s=new Solution();
    int[] arr={2,3,2,3,5};
    s.frequencyCount(arr, 5, 5);
   }

}
