//Problem:https://www.geeksforgeeks.org/problems/prime-factors5052/1
import java.util.ArrayList;
import java.util.Arrays;
class Solution{
public int[] AllPrimeFactorsBruteForce(int N) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2;i<=N;i++){
            if(N%i==0){
                if(prime(i)) arr.add(i);
            }
        }
        int[] ans = new int[arr.size()];
        int i=0;
        for(int ele : arr){
            ans[i++]=ele;
        }
        return ans;
    }


    public int[] AllPrimeFactorsBetter(int N) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=sqrt(N);i++){
            if(N%i==0){
                if(prime(i)) arr.add(i);
            
            if(N/i != i) if(prime(N/i)) arr.add(N/i);
            }
        }
        int[] ans = new int[arr.size()];
        int i=0;
        for(int ele : arr){
            ans[i++]=ele;
        }
        return ans;
    }

     public int[] AllPrimeFactorsOptimal(int N) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2;i<=sqrt(N);i++){
            if(N%i==0){
               arr.add(i);
               while(N%i==0) N=N/i;
            }
        }
        if(N != 1) arr.add(N);
        int[] ans = new int[arr.size()];
        int i=0;
        for(int ele : arr){
            ans[i++]=ele;
        }
        return ans;
    }
    
    private boolean prime(int ele){
       // System.out.println(ele);
        if(ele <=1) return false;
        if(ele ==2 ) return true;
        for(int i=2;i<=sqrt(ele);i++){
            if(ele%i==0) return false;
        }
        return true;
    }
    private int sqrt(int n){
        if(n<1) return n;
        int low = 1;
        int high = n/2;
        int ans =0;
        while(low <= high){
            int mid = (low+high)/2;
            if(mid <= n/mid){
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
}
public class Problem15 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 100;
        System.out.println("Brute Force:"+Arrays.toString(s.AllPrimeFactorsBruteForce(num)));
        System.out.println("Better:"+Arrays.toString(s.AllPrimeFactorsBetter(num)));
        System.out.println("Optimal:"+Arrays.toString(s.AllPrimeFactorsOptimal(num))); 
    }
}

