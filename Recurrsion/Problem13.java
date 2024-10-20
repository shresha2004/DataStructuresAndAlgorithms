//Problem:https://leetcode.com/problems/power-of-two/?envType=problem-list-v2&envId=recursion&difficulty=EASY
class Solution {
   
   
      public boolean isPowerOfTwo(int n) {
          
          boolean isPow=power(n); 
          return isPow;
      }
  
      public boolean power(double x){
  
          if(x==1){
             
              return  true;
          }
          if(x<1){
              return false;
  
          }
          if(x>1){
               x=x/2;
          }
         
         return power(x);
      }
  
  }
public class Problem13 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.isPowerOfTwo(4));
    }
}
