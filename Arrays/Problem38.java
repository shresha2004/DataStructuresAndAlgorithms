//Problem:https://leetcode.com/problems/merge-intervals/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int[][] mergeBruteForce(int[][] intervals) {
        int n = intervals.length;
        
      Arrays.sort(intervals,new Comparator<int[]>(){
        public int compare(int[] a, int[] b){
            return a[0]-b[0];
        }
      });
      List<int[]> ans = new  ArrayList<>();

      for(int i=0;i<n;i++){
        int start = intervals[i][0];
        int end = intervals[i][1];
        if(!ans.isEmpty() && end <= ans.get(ans.size()-1)[1]){
            continue;
        }
        for(int j=i+1;j<n;j++){
            if(intervals[j][0]<=end){
                end = Math.max(end,intervals[j][1]);
            }
            else{
                break;
            }
        }
        ans.add(new int[]{start, end});
      }
      return ans.toArray(new int[ans.size()][]);
    }


    public int[][] mergeOptimal(int[][] intervals) {
        int n = intervals.length;
        
      Arrays.sort(intervals,new Comparator<int[]>(){
        public int compare(int[] a, int[] b){
            return a[0]-b[0];
        }
      });
      List<int[]> ans = new  ArrayList<>();

      for(int i=0;i<n;i++){
        
        if(ans.isEmpty() || intervals[i][0]>ans.get(ans.size()-1)[1]){
           ans.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        
            else{
               ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);            }
        }
        
      
      return ans.toArray(new int[ans.size()][]);
    }
}



public class Problem38 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };
            System.out.println("Brute Force Approach:"+Arrays.deepToString( s.mergeBruteForce(intervals)));
            System.out.println("Brute Force Approach:"+Arrays.deepToString( s.mergeOptimal(intervals)));
    }
}

