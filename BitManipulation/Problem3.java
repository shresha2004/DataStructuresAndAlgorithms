//Problem:https://leetcode.com/problems/number-of-1-bits/description/?envType=problem-list-v2&envId=bit-manipulation
class Solution{
 public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if(n%2==1) count++;
            n= n/2;
        }
        return count;
    }
}
public class Problem3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 11;
        System.out.println("Brute Force:"+s.hammingWeight(num));
    }
}

