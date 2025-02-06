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
}

public class Problem24 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int  n = 10;
        System.out.println("My Brute Force:"+s.arrangeCoinsMyBruteForce(n));
        
    }
}
