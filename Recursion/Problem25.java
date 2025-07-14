//Problem:https://leetcode.com/problems/subsets-ii/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3BruteForce(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> check = new ArrayList<>();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        backtrack(arr, k, n, ans, check, 0, 0);
        return ans;
    }

    private void backtrack(int[] arr, int tnums, int sum, List<List<Integer>> ans, List<Integer> check, int index,
            int checkSum) {
        if (sum < checkSum)
            return;
        if (index == arr.length) {
            if (checkSum == sum && check.size() == tnums)
                ans.add(new ArrayList<>(check));
            return;
        }
        check.add(arr[index]);
        backtrack(arr, tnums, sum, ans, check, index + 1, checkSum + arr[index]);
        check.remove(check.size() - 1);
        backtrack(arr, tnums, sum, ans, check, index + 1, checkSum);
        return;
    }

    public List<List<Integer>> combinationSum3Optimal(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> check = new ArrayList<>();
       backtrack1(k,n,ans,check,1,0);
       return ans;
    }
    private void backtrack1(int tnums,int sum,List<List<Integer>> ans,List<Integer> check,int index,int checkSum){
        if(sum < checkSum|| check.size()>tnums) return;
        if(check.size()==tnums && checkSum==sum){
            ans.add(new ArrayList<>(check));
            return;
        }
        for(int i=index;i<10;i++){
        check.add(i);
        backtrack1(tnums,sum,ans,check,i+1,checkSum+i);
        check.remove(check.size()-1);
        
        }
        return;
    }
}

public class Problem25 {
    public static void main(String[] args) {
        int k = 3, n = 7;
        Solution s = new Solution();
        System.out.println("My Brute Force:"+s.combinationSum3BruteForce(k, n));
        System.out.println("Optimal:"+s.combinationSum3Optimal(k, n));
    }
}
