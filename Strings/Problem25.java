//Problem:https://leetcode.com/problems/robot-return-to-origin/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
 public boolean judgeCircle(String moves) {
        int horizontal=0;
        int vertical = 0;

        for(int i=0;i<moves.length();i++){
            char h = moves.charAt(i);
            if(h=='U') vertical++;
            if(h=='R') horizontal++;
            if(h=='D') vertical--;
            if(h=='L') horizontal--;
        }
        return (horizontal==0 && vertical == 0);
    }
}
public class Problem25 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss= "UD" ;
        System.out.println("Brute Force:"+s.judgeCircle(ss));
      

        
    }
}
