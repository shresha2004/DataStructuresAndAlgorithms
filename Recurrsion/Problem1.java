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
