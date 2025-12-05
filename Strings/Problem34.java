//Problem:https://leetcode.com/problems/relative-ranks/description/
import java.util.*;
class Solution{
public String[] findRelativeRanks(int[] score) {
       TreeMap<Integer,Integer> map = new TreeMap<>();
       int n = score.length;
       for(int i=0;i<n;i++)
            map.put(score[i],i);

        String[] ans = new String[n];

       List<Integer> index = new ArrayList<>(map.values());
                System.out.println(index);
        for(int i=0;i<n;i++){
            if(i==n-3){
            ans[index.get(i)]="Bronze Medal";
           
            continue;
            }
            if(i==n-2){
            ans[index.get(i)]="Silver Medal";
           
            continue;
            }
            if(i==n-1){
            ans[index.get(i)]="Gold Medal";
            continue;
            }
           ans[index.get(i)]=Integer.toString(n-i);
           
        }
        return ans;
    }
}
public class Problem34 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] score = {5,4,3,2,1};
        System.out.println("Solution:"+s.findRelativeRanks(score));
       
    }
}
