//Problem:https://leetcode.com/problems/sum-of-subarray-minimums/description/
import java.util.Arrays;
import java.util.Stack;
class Solution {
    public int sumSubarrayMinsBruteForce(int[] arr) {
        int ans =0;
        int mod = 1000000000+7;
        for(int i=0;i<arr.length;i++){
            int min=arr[i];
            for(int j=i;j<arr.length;j++){
              min=Math.min(arr[j],min);
                ans =(ans+ min)%mod;
                
            }
            
        }
        return ans;
    }
    public int sumSubarrayMinsOptimal(int[] arr) {
     int[] nse = arrIndOfNSE(arr);
     int[] pse = arrIndOfPSEE(arr);
     int mod = 1000000000+7;
     int n = arr.length;
     int total = 0;
     for(int i=0;i<n;i++){
        int left = i - pse[i];
        int right = nse[i] - i;
        long contribute = ((long) left*right)%mod;
        contribute = (contribute * arr[i]) %mod;
         total =(int) ((total+contribute)%mod);
     }
        return total;
    }

    private int[] arrIndOfNSE(int[] arr){
        Stack<Integer> st = new Stack<>();
       int[] nse = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();

            if(st.isEmpty()) nse[i]=arr.length;
            else nse[i] = st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] arrIndOfPSEE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]) st.pop();

            if(st.isEmpty()) pse[i]=-1;
            else pse[i] = st.peek();

            st.push(i);
        }
        return pse;
    }
}



public class Problem17 {
    public static void main(String[] args) {
     Solution s = new Solution();
     int[]  arr = {3,1,2,4};
     System.out.println("Brute Force:"+s.sumSubarrayMinsBruteForce(arr));
     System.out.println("Optimal:"+s.sumSubarrayMinsOptimal(arr));
    }
}
