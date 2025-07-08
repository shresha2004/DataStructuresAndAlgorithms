//Problem:https://leetcode.com/problems/ugly-number/description/
class Solution{
 public boolean isUglyBruteForce(int n) {
     if(n<=0) return false;
    
       for(int i=2;i*i<=n;i++){
        if(n%i==0){
            while(n%i ==0) n=n/i;
            if(i>5) return false;
        } 
       }
       if(n != 1 && n>5) return false;
       return true;
    }

     public boolean isUglyOptimal(int n) {
     if(n<=0) return false;
     int[] factors= {2,3,5};

     for(int f : factors){
        if(n%f==0){
            while(n%f == 0) n/=f;
        }
     }
     return n==1;
    }
}
public class Problem19 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 9; 
        System.out.println("Brute Force:"+s.isUglyBruteForce(num));

        
        System.out.println("Optimal:"+s.isUglyBruteForce(num));
    }
}
