class Solution {
    public int balancedStringSplit(String s) {
        int r=0;
        int l=0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L') l++;
           else r++;
            if(l==r){
                count++;
              
            }
        }
        return count;
    }
}
public class Problem31{
    public static void main(String[] args){
        String ss="RRRLLLRLRLRLRL";
        Solution s = new Solution();
        System.out.println("Solution:"+s.balancedStringSplit(ss));
    }
}