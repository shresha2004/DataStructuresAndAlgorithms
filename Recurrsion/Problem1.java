//Problem:https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1
class Solution
{
    int count =0;
  public void printNos(int N)
    {
        //Your code here
        if (N==0){
            return ;
        }
        count=count+1;
        N=N-1;
      System.out.print(count+" ");
      printNos(N);
        
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Solution s= new Solution();
        s.printNos(10);
    }
}
