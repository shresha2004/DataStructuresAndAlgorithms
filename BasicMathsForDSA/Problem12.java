//Problem:https://leetcode.com/problems/add-to-array-form-of-integer/description/?envType=problem-list-v2&envId=array

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution{
 public List<Integer> addToArrayForm(int[] num, int k) {
        long number = 0;
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        int i = num.length-1;
       while(i>=0 || k>0 || carry>0){
        int digit = (i>=0?num[i]:0);
        int add = digit+k%10+carry;
        carry = add/10;
        ans.add(add%10);
        k/=10;
        i--;
       }
       Collections.reverse(ans);
     return ans;
    }
}
public class Problem12 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {1,2,0,0};
        int k = 34;
       System.out.println("Optimal:"+s.addToArrayForm(num, k));
    }
}
