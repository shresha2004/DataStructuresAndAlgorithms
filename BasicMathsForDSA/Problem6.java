//PrimeNo problem: Optimal solution
class Solution {
    public boolean primeNo(int n) {
        
        boolean isPrimeNo=true;
        if(n<=1){
            isPrimeNo=false;
        }
        if(n==2 || n==3){
            isPrimeNo=true;
        }
        if(n%2==0 || n%3==0){
            isPrimeNo=false;
        }

       for(int i=5;i*i<=n;i+=6){
        if(n%(i)==0 || n%(i+2)==0){
            isPrimeNo=false;
        }

       }
       
          return isPrimeNo;  
        }
    }
public class Problem6 {
    public static void main(String[] args) {
        Solution s=new Solution();
        
        System.out.println(s.primeNo(13));
    }
    
}
