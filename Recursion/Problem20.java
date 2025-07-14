//Problem:https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1
class Solution{
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
         return checkSum(N,arr,0,0,K);
       
    }
    private static boolean checkSum(int len,int[] arr,int checkSum,int index,int k){
        if(checkSum > k) return false;
        if(index == len ){  
       return checkSum ==k;
        }
       if(checkSum(len,arr,checkSum+arr[index],index+1,k)) return true;
       if(checkSum(len,arr,checkSum,index+1,k)) return true;
        return false;
    }
}
public class Problem20 {
    public static void main(String[] args) {
        int[] arr ={ 10,1,2,7,6,1,5};
        int k= 8;
        Solution s = new Solution();
        System.out.println("Recursive:"+s.checkSubsequenceSum(7, arr, k));
    }
}
