//Problem:https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array
import java.util.ArrayList;
class Solution {
    static ArrayList<Integer> leadersBruteForce(int arr[]) {
        // code here
        int n=arr.length;
        ArrayList<Integer> nums=new ArrayList<>();
        if(n==0) return nums;
        if(n>1){
        for(int i=0;i<n-1;i++){
            boolean leader=true;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i])  {
                    leader=false;
                    break;
                }      
            }
            if(leader==true) nums.add(arr[i]);
        }
        }
        nums.add(arr[n-1]);
        return nums;
    }
}
public class Problem25 {
     public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {16, 17, 4, 3, 5, 2};
      System.out.println("BruteForce Approach:"+s.leadersBruteForce(nums));
      System.out.println("Optimal Approach:"+s.leadersBruteForce(nums));
     
     
    }
}
