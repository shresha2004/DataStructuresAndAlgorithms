



class Solution{
    int evenlyDivides(int N){
      int   count=0;
      int digit = N;
       while(digit >0){
        int number =(digit%10);
            if(number !=0 && N%number==0){
                count++;
            }
            digit=digit/10;
       }
       System.out.println(count);

        return count;
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Solution s=new Solution();
        s.evenlyDivides(20074);
        
    }
    
}
