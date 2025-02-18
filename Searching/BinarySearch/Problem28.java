package BinarySearch;

//Problem:https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
import java.util.ArrayList;
import java.util.Arrays;

 class Solution 
{
    public  int findLargestMinDistanceBruteForce(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(int board : boards){
            if(board > low) low = board;
            high += board;
        }
       int ans=low;
        for(int checkMin = low;checkMin<=high;checkMin++){
            int temp = minDist(boards,checkMin);
            if(temp<=k)return checkMin;
        }
        return ans;
    }
    public  int findLargestMinDistanceOptimal(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(int board : boards){
            if(board > low) low = board;
            high += board;
        }
        int result =0;
      while(low<= high){
          int mid = (low+high)/2;
          if(minDist(boards,mid)<=k){
              result = mid;
              high = mid-1;
          }else low = mid+1;
      }
        return result;
    }
    private  int minDist(ArrayList<Integer> boards,int checkMin){
        int n = boards.size();
        int sum = 0;
        int count = 1;
        for(int i =0 ;i<n;i++){
            if(boards.get(i)+sum > checkMin )
            {
                sum = boards.get(i);
                count++;
               
            }else {
                 sum += boards.get(i);
            }

        }
        return count;
        
    }
}
public class Problem28 {
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        int k = 2;
        System.out.println("Brute Force:"+s.findLargestMinDistanceBruteForce(boards, k));
        System.out.println("Optimal:"+s.findLargestMinDistanceOptimal(boards, k));
    }
}
