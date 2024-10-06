class Solution{
    public boolean isAmstrong(int x){
        int number =x;
        boolean amstrong=false;
      int  amstrongNumber=0;
        while(number > 0){
            int digit =number%10;
            
            amstrongNumber=(amstrongNumber)+ (int) Math.pow(digit,3);
          
            number=number/10;
        }
        if (amstrongNumber==x){
            amstrong=true;
        }
        return amstrong;
    }
}
public class Problem4 {

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.isAmstrong(1634));
    }
}
