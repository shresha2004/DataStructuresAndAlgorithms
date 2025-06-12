//Problem:https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
class Solution{
public int minBitFlipsBruteForce(int start, int goal) {
        String s = convertToBinary(start);
        String g = convertToBinary(goal);
        int count = 0;
        if (g.length() < s.length())
            for (int i = g.length(); i < s.length(); i++)
                g = "0" + g;
        else if (s.length() < g.length())
            for (int i = s.length(); i < g.length(); i++)
                s = "0" + s;
        for (int i = g.length() - 1; i >= 0; i--) {
            if (i >= s.length()) {
                count++;
                continue;
            }
            if (g.charAt(i) != s.charAt(i))
                count++;
        }
        return count;
    }

    private String convertToBinary(int num) {
        if (num == 0)
            return "0";
        String ans = "";
        while (num != 1) {
            if (num % 2 == 0)
                ans += "0";
            else
                ans += "1";
            num /= 2;
        }
        ans += "1";
        return reverse(ans);
    }

    private String reverse(String ele) {
        char[] charArr = ele.toCharArray();
        int start = 0;
        int end = charArr.length - 1;
        while (start <= end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
        return new String(charArr);
    }
     public int minBitFlipsOptimal(int start, int goal) {
       int ans = start ^ goal;
       int count = 0;
      
       for(int i=0;i<31;i++){
      
        if((ans & (1<<i))!=0) count++;
       }
       return count;
    }
}
public class Problem11 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int start = 5;
        int goal = 8;
        System.out.println("Brute Force:"+s.minBitFlipsBruteForce(start, goal));
        
        
        System.out.println("Optimal:"+s.minBitFlipsOptimal(start, goal));
        
    }
}

