//Problem:https://www.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1
class Solution{
static int setBitBruteForce(int n) {
        // code here
        String str = Integer.toBinaryString(n);
        char[] charArray = str.toCharArray();
        int flag = 0;
        for(int i=charArray.length-1;i>=0;i--){
            if(charArray[i]=='0'){
                flag = 1;
                charArray[i]='1';
                break;
            }
        }
        String ans = new String(charArray);
        if(flag==0) ans+="1";
        
        return Integer.parseInt(ans,2);
    }
}
public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 6;
        System.out.println("Brute Force:"+s.setBitBruteForce(num));
    }
}

