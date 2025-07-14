

//Problem: backtracking
class Solution{
    int count =0;
    public void backtrack(int n){
      if(n==0){
          return;
      }
       count=count+1;
      backtrack(n-1);
   
      System.out.print(n+" ");
       count=count-1;
     }
  }
  public class Problem3 {
      public static void main(String[] args) {
          Solution s=new Solution();
          s.backtrack(10);
      }
  }
  