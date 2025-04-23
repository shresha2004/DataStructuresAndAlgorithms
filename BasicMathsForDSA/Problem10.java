//Problem:https://leetcode.com/problems/count-the-digits-that-divide-a-number/description/?envType=problem-list-v2&envId=prshgx6i
class Solution {
    public int countDigitsOptimal(int num) {
        int count = 0;
        int temp = num;
        while (temp != 0) {
            int check = temp % 10;
            if (num % check == 0)
                count++;
            temp = temp / 10;
        }
        return count;
    }
}

public class Problem10 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 121;
        System.out.println("Optimal:"+s.countDigitsOptimal(num));
    }
}
