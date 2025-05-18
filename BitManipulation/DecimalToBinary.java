class Solution{
    public String decimal2Binary(int x){
        String  res = "";
        while(x != 1){
            if(x%2==1) res+="1";
            else res+="0";
            x=x/2;
        }
        res+="1";
      return  reverse(res);
    }
    private String reverse(String res){
        char[] arr = res.toCharArray();
        int end = arr.length-1;
        int start = 0;
        while(start <= end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
        return new String(arr);
    }
    public int BinaryToDecimal(String x){
        int len = x.length()-1;
        int p2=1;
        int num =0;
        while(len>=0){
            if(x.charAt(len)=='1'){
                num = num + p2;
            }
            p2=p2*2;
            len--;
        }
        return num;
    }
}
public class DecimalToBinary {
    public static void main(String[] args){
        Solution s = new Solution();
        String res = s.decimal2Binary(13);
        System.out.println("Decimal to Binary:"+res);
        System.out.println("Binary to Decimal:"+s.BinaryToDecimal(res));
    }
}
