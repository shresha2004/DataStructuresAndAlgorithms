import java.util.HashSet;

class Solution {

    public boolean isHappyBruteForce(int n) {
       HashSet<Integer> set = new HashSet<>();
       while(n != 1){
        if(set.contains(n)) return false;
        set.add(n);
        n = getNumber(n);
       }
     return true;
    }

    
    public boolean isHappyOptimal(int n) {
        int slow = n, fast =n;
        do{
          slow=getNumber(slow);
          fast=getNumber(getNumber(fast));
        }while(slow != fast);
  
        return slow==1;
      }
    private int getNumber(int n){
        int sum = 0;
        while(n>0){
            int temp = n%10;
            temp = temp * temp;
            sum+=temp;
            n /= 10;
        }
        return sum;
    }
}
public class Problem51 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num =9;
        System.out.println("Brute Force:"+s.isHappyBruteForce(num));
        System.out.println("Optimal:"+s.isHappyOptimal(num));
    }
}
