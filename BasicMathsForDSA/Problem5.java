class Solution{
    public long sumOfDivisors(int N){
        long sum =0;
        for(int i=1;i<=N;i++){
            sum=sum+(N/i)*i;
        }
        return sum;
    } 
}
public class Problem5 {
    public static void main(String[] args) {
        Solution s=new Solution();
      System.out.println( s.sumOfDivisors(4)); 
    }
}
