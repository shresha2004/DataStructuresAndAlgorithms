//Problem:https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest
class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int n=arr.length;
        int Largest=arr[0];
        int SLargest=-1;
        for(int i=1;i<n;i++){
            if(arr[i]> Largest){
               
                SLargest=Largest;
                Largest=arr[i];
               
                
            }
            else if(arr[i]>SLargest && arr[i]<Largest) SLargest=arr[i];
            
        }
        return SLargest;
    }
}
public class Problem2 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(s.getSecondLargest(arr));
        
    }
    
}
