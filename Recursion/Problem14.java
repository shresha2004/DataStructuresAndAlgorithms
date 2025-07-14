//Problem:https://leetcode.com/problems/power-of-three/description/?envType=problem-list-v2&envId=recursion&difficulty=EASY
class Solution {
 
    public boolean isPowerOfThree(int n) {
        boolean checkPower=power(n);
        return checkPower;
    }
    public boolean power(double n){
        if(n==1){
            return true;
        }
        if(n<1){
            return false;
        }
        if(n>1){
        n=n/3;
        }
       return power(n);

        

    }
}
public class Problem14 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfThree(9));
    }
}
