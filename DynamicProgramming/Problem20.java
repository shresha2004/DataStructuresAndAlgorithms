//Problem:https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
import java.util.Arrays;
class Solution {
     int countPartitionsRecursive1(int[] arr, int d) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
        return partitionsRecursive1(arr,d,n,totalSum,0,0);
    }
    
    private int partitionsRecursive1(int arr[],int d,int n,int totalSum,int checkSum,int index){
        if(index == arr.length){
            int otherSum = totalSum - checkSum;
            if((checkSum >= otherSum)&&((checkSum-otherSum)==d)) return 1;
            return 0;
        }
        int left = partitionsRecursive1(arr,d,n,totalSum,(checkSum+arr[index]),index+1);
        int right = partitionsRecursive1(arr,d,n,totalSum,checkSum,index+1);
        return right+left;
    }
    int countPartitionsMemo1(int[] arr, int d) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
        
        int[][] memo = new int[arr.length][totalSum+1];
        for(int i=0;i<n;i++){
          Arrays.fill(memo[i],-1);
        }
        return partitionsMemo1(arr,d,n,totalSum,0,0,memo);
    }
    
    private int partitionsMemo1(int arr[],int d,int n,int totalSum,int checkSum,int index,int[][] memo){
        if(index == arr.length){
            int otherSum = totalSum - checkSum;
            if((checkSum >= otherSum)&&((checkSum-otherSum)==d)) return 1;
            return 0;
        }
        if(memo[index][checkSum] != -1) return memo[index][checkSum];
        int left = partitionsMemo1(arr,d,n,totalSum,(checkSum+arr[index]),index+1,memo);
        int right = partitionsMemo1(arr,d,n,totalSum,checkSum,index+1,memo);
        
        return memo[index][checkSum]=right+left;
    }

      

 int countPartitionsMemo2(int[] arr, int d) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
        if((totalSum - d)%2 != 0 || (totalSum-d)<0)    return 0;
        int sum = (totalSum - d)/2;
        int[][] memo = new int[arr.length][sum+1];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(memo[i],-1);
        return partitionsMemo2(arr,n,sum,0,0,memo);
    }
    
    private int partitionsMemo2(int arr[],int n,int sum,int checkSum,int index,int[][] memo){
                if(checkSum > sum) return 0;
        if(index == arr.length){
            
            if(checkSum == sum) return 1;
            return 0;
        }
        if(memo[index][checkSum] != -1) return memo[index][checkSum];
        int left = partitionsMemo2(arr,n,sum,(checkSum+arr[index]),index+1,memo);
        int right = partitionsMemo2(arr,n,sum,checkSum,index+1,memo);
        return memo[index][checkSum]=right+left;
    }

     int countPartitionsTabu2(int[] arr, int d) {
        // code here
        int n = arr.length;
        
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
            
            
        if((totalSum - d)%2 != 0 || (totalSum-d)<0)    return 0;
        
        int sum = (totalSum - d)/2;
        
        int[][] tabu = new int[arr.length][sum+1];
        
        
            if(arr[0]==0) tabu[0][0]=2;
            else tabu[0][0]=1;
            
          if(arr[0] != 0 && arr[0]<=sum)  tabu[0][arr[0]]=1;
        
        for(int i=1;i<arr.length;i++){
            for(int t=0;t<=sum;t++){
                int notTake = tabu[i-1][t];
                int take = 0;
                if(arr[i]<= t) take = tabu[i-1][t-arr[i]];
                tabu[i][t]=take + notTake;
            }
        }
        return tabu[n-1][sum];
    }

     int countPartitionsSpaceOpti(int[] arr, int d) {
        // code here
        int n = arr.length;
        
        int totalSum = 0;
        for(int i=0;i<n;i++)
            totalSum += arr[i];
            
            
        if((totalSum - d)%2 != 0 || (totalSum-d)<0)    return 0;
        
        int sum = (totalSum - d)/2;
        
        int[] spo = new int[sum+1];
        
        
            if(arr[0]==0) spo[0]=2;
            else spo[0]=1;
            
          if(arr[0] != 0 && arr[0]<=sum)  spo[arr[0]]=1;
        
        for(int i=1;i<arr.length;i++){
            int[] temp = new int[sum+1];
            for(int t=0;t<=sum;t++){
                int notTake = spo[t];
                int take = 0;
                if(arr[i]<= t) take = spo[t-arr[i]];
                temp[t]=take + notTake;
            }
            spo=temp;
        }
        return spo[sum];
    }
}
public class Problem20 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] arr =  {1,1,1,1};
       int d = 0;
       //My approach
       System.out.println("Recursive:"+s.countPartitionsRecursive1(arr, d));
       System.out.println("Memoization:"+s.countPartitionsMemo1(arr, d));

       //Actual Approach
        System.out.println("Memoization:"+s.countPartitionsMemo2(arr, d));
        System.out.println("Tabulation:"+s.countPartitionsTabu2(arr, d));
        System.out.println("Space Optimization:"+s.countPartitionsSpaceOpti(arr, d));

    }
}
