//Problem:https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
import java.util.*;
class Solution{
     static int matrixMultiplicationRecursive(int arr[]) {
        // code here
       return findMinRecursive(arr,1,arr.length-1) ;
    }
    
    static int findMinRecursive(int[] arr,int i,int j){
        if(i==j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int steps = arr[i-1]*(arr[k]*arr[j]) + findMinRecursive(arr,i,k)+findMinRecursive(arr,k+1,j);
            min = Math.min(min,steps);
        }
        return min;
        
    }
 static int matrixMultiplicationMemo(int arr[]) {
        // code here
        int[][] memo = new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(memo[i],-1);
       return findMinMemo(arr,1,arr.length-1,memo) ;
    }
    
    static int findMinMemo(int[] arr,int i,int j,int[][] memo) {
        if(i==j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int steps = arr[i-1]*(arr[k]*arr[j]) + findMinMemo(arr,i,k,memo)+findMinMemo(arr,k+1,j,memo);
            min = Math.min(min,steps);
        }
        return memo[i][j]=min;
        
    }
    static int matrixMultiplicationTabu(int arr[]) {
        // code here
        int n = arr.length;
        int[][] tabu = new int[n][n];
        for(int i=0;i<n;i++)
            tabu[i][i]=0;
        
        for(int i=n-1;i>=1;i--){
            
            for(int j=i+1;j<n;j++){
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                  int steps = arr[i-1]*(arr[k]*arr[j])+tabu[i][k]+tabu[k+1][j];
                  if(steps < mini) mini=steps;
                }
                tabu[i][j]=mini;
            }
        }
       return tabu[1][n-1];
    }
}
public class Problem48 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr= {2, 1, 3, 4};
        System.out.println("Recursive:"+s.matrixMultiplicationRecursive(arr));
        System.out.println("Memoization:"+s.matrixMultiplicationMemo(arr));
        System.out.println("Tabulation:"+s.matrixMultiplicationTabu(arr));
    }
}
