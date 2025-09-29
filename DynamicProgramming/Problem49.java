
//Problem:https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
import java.util.*;

class Solution {
    public int minCostRecursive(int n, int[] cuts) {
        int len = cuts.length;
        int[] editCuts = new int[len + 2];
        for (int i = 0; i < len; i++)
            editCuts[i] = cuts[i];
        editCuts[len] = 0;// Add 0 for intial pointing;
        editCuts[len + 1] = n;// Add len of cuts for end pointing.After sorting it will be corrected
        mergeSort(editCuts, 0, len + 1);
        return findMinCostRecursive(editCuts, 1, len);
    }

    private int findMinCostRecursive(int[] editCuts, int i, int j) {
        if (i > j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = (editCuts[j + 1] - editCuts[i - 1]) + findMinCostRecursive(editCuts, i, ind - 1)
                    + findMinCostRecursive(editCuts, ind + 1, j);
            min = Math.min(min, cost);
        }
        return min;
    }

     public int minCostMemo(int n, int[] cuts) {
        int len = cuts.length;
        int[] editCuts = new int[len+2];
        for(int i=0;i<len;i++)
            editCuts[i]=cuts[i];
            editCuts[len]=0;//Add 0 for intial pointing;
            editCuts[len+1]=n;//Add len of cuts for end pointing.After sorting it will be corrected
        mergeSort(editCuts, 0, len+1);
        int[][] memo = new int[editCuts.length][editCuts.length];
        for(int i=0;i<editCuts.length;i++)
            Arrays.fill(memo[i],-1);
        return findMinCostMemo(editCuts, 1, len,memo);
    }
    private int findMinCostMemo(int[] editCuts,int i,int j,int[][] memo){
        if(i>j) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int min = Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = (editCuts[j+1]-editCuts[i-1])+findMinCostMemo(editCuts,i,ind-1,memo)+findMinCostMemo(editCuts,ind+1,j,memo);
            min = Math.min(min,cost);
        } 
        return memo[i][j]=min;
    }


    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }

    }

    private void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int size = end - start + 1;
        int[] temp = new int[size];
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else
                temp[k++] = nums[i++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (int a = 0; a < size; a++) {
            nums[start + a] = temp[a];
        }
    }
}

public class Problem49 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 7;
        int[] cuts = {1,3,4,5};
        System.out.println("Recursive:"+s.minCostRecursive(n, cuts));
        System.out.println("Memoization:"+s.minCostMemo(n, cuts));
    }
}
