//Problem:https://leetcode.com/problems/find-the-maximum-achievable-number/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
 public int theMaximumAchievableX(int num, int t) {
        int x = num + t;
     return x+t; 

    }
}
public class Problem15 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 4, t = 1;
        System.out.println("Answer:"+s.theMaximumAchievableX(num, t));
    }
}
