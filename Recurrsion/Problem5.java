import java.util.ArrayList;
class Solution {
    static ArrayList<Long> s= new ArrayList<>();
   static long count =1 ;
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        int i=1;
        while( count<=n ){
             s.add(count);
             i++;
            count =count*i;
           
        }
        return s;
    }
}
public class Problem5 {
    public static void main(String[] args) {
      
        ArrayList<Long> a=Solution.factorialNumbers(9);
        System.out.println(a.toString());
    }
    
}
