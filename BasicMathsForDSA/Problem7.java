//Problem:https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1
import java.util.Arrays;

class Solution {
    public Long[] lcmAndGcd(Long A , Long B) {
        // code here
        long gcd=gcd(A,B);
        long lcm=(A*B)/gcd;
        
        return new Long[] {lcm,gcd};
  
    }
    
public long gcd(long x, long y){
      if(x==0) return y;
        if(y==0) return x;
        if(x>y) return gcd(x%y,y);
        else{
          return  gcd(y%x,x);
            
        }
     
}

};
public class Problem7 {
    public static void main(String[] args) {
        Solution s= new Solution();
        Long[] result=s.lcmAndGcd(10L,6L);
        
      System.out.println(Arrays.toString(result));  
    }
}
