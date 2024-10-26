//Problem:https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
import java.util.HashMap;
class Solution {
    // Function for finding maximum and value pair
    public  int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
        int index=0;
      HashMap<Integer,Integer> hash= new HashMap<>();
      
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=A[i];
            if(sum==K) index=Math.max(i+1,index) ;
            
            if(hash.containsKey(sum-K)){
               index=Math.max(index,i-hash.get(sum-K));
            }
            
            if(!hash.containsKey(sum)){
                hash.put(sum,i);
            }
        }
        
        
        return index;
    }
}



public class Problem11 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums = {10, 5, 2, 7, 1, 9};
        System.out.println(s.lenOfLongSubarr(nums,6,15));
    }
}
