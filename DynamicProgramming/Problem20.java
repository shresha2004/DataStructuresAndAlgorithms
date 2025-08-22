//Problem:https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
import java.util.Arrays;
class Solution {
     int countPartitionsRecursive(int[] arr, int d) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
        return partitionsRecursive(arr,d,n,totalSum,0,0);
    }
    
    private int partitionsRecursive(int arr[],int d,int n,int totalSum,int checkSum,int index){
        if(index == arr.length){
            int otherSum = totalSum - checkSum;
            if((checkSum >= otherSum)&&((checkSum-otherSum)==d)) return 1;
            return 0;
        }
        int left = partitionsRecursive(arr,d,n,totalSum,(checkSum+arr[index]),index+1);
        int right = partitionsRecursive(arr,d,n,totalSum,checkSum,index+1);
        return right+left;
    }
    int countPartitionsMemo(int[] arr, int d) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
        
        int[][] memo = new int[arr.length][totalSum+1];
        for(int i=0;i<n;i++){
          Arrays.fill(memo[i],-1);
        }
        return partitionsMemo(arr,d,n,totalSum,0,0,memo);
    }
    
    private int partitionsMemo(int arr[],int d,int n,int totalSum,int checkSum,int index,int[][] memo){
        if(index == arr.length){
            int otherSum = totalSum - checkSum;
            if((checkSum >= otherSum)&&((checkSum-otherSum)==d)) return 1;
            return 0;
        }
        if(memo[index][checkSum] != -1) return memo[index][checkSum];
        int left = partitionsMemo(arr,d,n,totalSum,(checkSum+arr[index]),index+1,memo);
        int right = partitionsMemo(arr,d,n,totalSum,checkSum,index+1,memo);
        
        return memo[index][checkSum]=right+left;
    }

      int countPartitionsTabu(int[] arr, int d) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
        
        boolean[][] tabu = new boolean[arr.length][totalSum+1];
        for(int i=0;i<n;i++)
            tabu[i][0]=true;
        tabu[0][arr[0]]= true;    
        for(int i=1;i<n;i++){
            for(int t=1;t<=totalSum;t++){
                boolean notTake = tabu[i-1][t];
                boolean take= false;
                if(arr[i]<=t)
                    take = tabu[i-1][t-arr[i]];
                tabu[i][t]=take || notTake;
            }
         
        }
        int count = 0;
        for(int i=0;i<=totalSum;i++){
            if(tabu[n-1][i]==true){
                int otherSum = totalSum-i;
                System.out.println(i+">"+otherSum);
                if(i>=otherSum && i-otherSum==d){
                    count++;
                }
            }
        }
        return count;
    }
}
public class Problem20 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] arr =  {1,1,1,1};
       int d = 0;
       System.out.println("Recursive:"+s.countPartitionsRecursive(arr, d));
       System.out.println("Memoization:"+s.countPartitionsMemo(arr, d));
        System.out.println("Tabulation:"+s.countPartitionsTabu(arr, d));
    }
}
