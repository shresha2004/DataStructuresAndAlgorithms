//Problem:https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
class Solution {

    
    static Boolean isSubsetSumRecursive(int arr[], int sum) {
        // code here
        return checkSubseqRecursive(arr,sum,0,0);
    }
    private static boolean checkSubseqRecursive(int[] arr, int sum,int checkSum,int i){
        if(checkSum == sum) return true;
        if(i >= arr.length) return false;
      boolean l= checkSubseqRecursive(arr,sum,checkSum+arr[i],i+1);
      boolean r = checkSubseqRecursive(arr,sum,checkSum,i+1);
      return l || r;
      
    }
    static Boolean isSubsetSumMemo(int arr[], int sum) {
        // code here
        Boolean[][] memo = new Boolean[arr.length][sum];
      
        return checkSubseqMemo(arr,sum,0,0,memo);
    }
    
    private static Boolean checkSubseqMemo(int[] arr, int sum,int checkSum,int i,Boolean[][] memo){
        if(checkSum == sum) return true;
        if(checkSum > sum) return false;
        if(i >= arr.length) return false;
        if(memo[i][checkSum] != null) return memo[i][checkSum];
     Boolean l= checkSubseqMemo(arr,sum,checkSum+arr[i],i+1,memo);
     Boolean r = checkSubseqMemo(arr,sum,checkSum,i+1,memo);
      return memo[i][checkSum]=(l || r);
      
    }

     static Boolean isSubsetSumTabu(int arr[], int sum) {
        // code here
        int n = arr.length;
        if(n==1) return sum==arr[0];
        boolean[][] tabu = new boolean[n][sum+1];
        
        //base 
        for(int i=0;i<arr.length;i++)
            tabu[i][0] = true;
            
         if(arr[0]<=sum)   tabu[0][arr[0]] = true;
            
        for(int i=1;i<n;i++){
            for(int target =1;target<=sum;target++){
                boolean notTake = tabu[i-1][target];
                boolean take = false;
                if(arr[i]<= target) take = tabu[i-1][target-arr[i]];
                tabu[i][target]=take || notTake;
            }
        }    
   
       
        return tabu[n-1][sum];
    }

     static Boolean isSubsetSumSpaceOpti(int arr[], int sum) {
        // code here
        int n = arr.length;
        if(n==1) return sum==arr[0];
        boolean[] spo = new boolean[sum+1];
       
        spo[0]=true;
        if(arr[0]<=sum) spo[arr[0]]= true;
        //base 
            
        for(int i=1;i<n;i++){
             boolean[] cur = new boolean[sum+1];
             cur[0]=true;
            for(int target =1;target<=sum;target++){
                boolean notTake = spo[target];
                boolean take = false;
                if(arr[i]<= target) take =spo[target-arr[i]];
               cur[target]=take || notTake;
            }
            spo = cur;
        }    
   
       
        return spo[sum];
    }
}
public class Problem16 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3};
        int target = 5;
        System.out.println("Recursive:"+s.isSubsetSumMemo(arr, target));
        System.out.println("Memoization:"+s.isSubsetSumMemo(arr, target));
        System.out.println("Tabulation:"+s.isSubsetSumTabu(arr, target));
        System.out.println("Space Optimization:"+s.isSubsetSumSpaceOpti(arr, target));
    }
}
