//Problem:https://leetcode.com/problems/plus-one/description/?envType=problem-list-v2&envId=array&difficulty=EASY
import java.util.Arrays;

class Solution {
    public int[] plusOneBruteForce(int[] digits) {
        int num = 0;
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            num = num * 10 + digits[i];
        }

        num = num + 1;
       

        if (String.valueOf(num).length() > n) {
            n = n + 1;
        }

        int[] arr = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num = num / 10;
        }
        
        return arr;
    }

    public int[] plusOneOptimal(int[] digits) {
       
        int n= digits.length;
        for(int i=n-1;i>-1;i--){
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        int[]  result=new int[n+1];
        result[0] =1;
        return result;
        }
}

public class Problem17 {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        Solution s= new Solution();
        System.out.println(Arrays.toString(s.plusOneBruteForce(digits)));
        System.out.println(Arrays.toString(s.plusOneOptimal(digits)));
    }
    
}
