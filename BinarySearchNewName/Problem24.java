package BinarySearch;
class Solution {
    public int arrangeCoinsMyBruteForce(int n) {
        int count =0;
        if(n==1) return 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                count++;
                if(count>n){
                    return i;
                }
            }
        }
       return 0; 
    }
    public int arrangeCoinsBetter(int n) {
        int row = 0;
        while((row+1) <= n){
            row++; 
            n -= row;
        }
       return row; 
    }

    public int arrangeCoinsOptimal(int n) {
        long low = 1;
        long high = n;
       
        while(low <= high){
         long mid = low + (high-low)/2;
          long coinsNeeded = (long)(mid*(mid+1))/2;//Sum of n natural numbers
          if(coinsNeeded == n ) return (int)mid;
          if(coinsNeeded < n) low = mid+1;
          else high = mid-1;
        }
        return (int)high;
      }
}

public class Problem24 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int  n = 10;
        System.out.println("My Brute Force:"+s.arrangeCoinsMyBruteForce(n));
        System.out.println("Better:"+s.arrangeCoinsBetter(n));
        System.out.println("Optimal:"+s.arrangeCoinsBetter(n));
        
    }
}
