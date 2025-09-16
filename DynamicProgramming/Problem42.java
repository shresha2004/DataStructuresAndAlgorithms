//Problem:https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1

import java.util.*;

class Solution{
   public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] maxLenArr = new int[n];
        Arrays.fill(maxLenArr,1);
        int[] hash = new int[n];
        for(int i=0;i<n;i++)
            hash[i]=i;
        
        for(int index =0;index<n;index++){
            for(int prev = 0;prev<index;prev++){
                if(arr[prev]<arr[index] && (1+maxLenArr[prev])>maxLenArr[index]){
                    maxLenArr[index]=1+maxLenArr[prev];
                    hash[index]=prev;
                }
            }
        }
        int maxLen = 0;
        int maxInd = 0;
        for(int i=0;i<n;i++){
            if(maxLenArr[i]>maxLen){
                maxLen = maxLenArr[i];
                maxInd = i;
            }
        }
        while(ans.size() != maxLen){
            ans.add(0,arr[maxInd]);
            maxInd = hash[maxInd];
        }
        return ans;
        
    }
}
public class Problem42 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int arr[] = {10, 20, 3, 40};
        System.out.println("Solution:"+s.getLIS(arr));

    }
}
