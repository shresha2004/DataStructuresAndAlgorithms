//Problem: backtracking
class Solution{
   
  public void backtrack(int n){
    if(n==0){
        return;
    }
    backtrack(n-1);
    System.out.print(n+" ");

   }
}
public class Problem2 {
    public static void main(String[] args) {
        Solution s=new Solution();
        s.backtrack(10);
    }
}
