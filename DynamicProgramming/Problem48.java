//Problem:https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
import java.util.*;
class Solution{
 static int matrixMultiplication(int arr[]) {
        // code here
        int[][] memo = new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(memo[i],-1);
       return findMin(arr,1,arr.length-1,memo) ;
    }
    
    static int findMin(int[] arr,int i,int j,int[][] memo) {
        if(i==j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int steps = arr[i-1]*(arr[k]*arr[j]) + findMin(arr,i,k,memo)+findMin(arr,k+1,j,memo);
            min = Math.min(min,steps);
        }
        return memo[i][j]=min;
        
    }
}
public class Problem48 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr= {2, 1, 3, 4};
        System.out.println("Solution:"+s.matrixMultiplication(arr));

    }
}
