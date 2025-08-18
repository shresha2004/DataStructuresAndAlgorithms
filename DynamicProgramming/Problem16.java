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
}
public class Problem16 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3};
        int target = 5;
        System.out.println("Recursive:"+s.isSubsetSumMemo(arr, target));
        System.out.println("Memoization:"+s.isSubsetSumMemo(arr, target));
    }
}
