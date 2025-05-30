//Problem:https://leetcode.com/problems/number-of-changing-keys/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
public int countKeyChangesBruteForce(String s) {
       String lowerCase = s.toLowerCase();
        int count = 0;
        for(int i=0;i<s.length()-1;i++){
            if(lowerCase.charAt(i) != lowerCase.charAt(i+1)) count++;
        }
        return count;
    }
}
public class Problem24 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss= "aAbBcC";
        System.out.println("Brute Force:"+s.countKeyChangesBruteForce(ss));
       // System.out.println("Optimal:"+s.);
    }
}
