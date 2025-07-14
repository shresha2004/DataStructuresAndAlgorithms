//Problem:https://leetcode.com/problems/generate-parentheses/description/
import java.util.ArrayList;
import java.util.List;
class Solution{
    public List<String> generateParenthesisOptimal(int n) {
        ArrayList<String> ans = new ArrayList<>();
        backTrack(ans,"",0,0,n);
        return ans;
    }
    private void backTrack(ArrayList<String> ans,String pairs,int open,int close,int n){
        if(pairs.length()==n*2){
            ans.add(pairs);
            return;
        }
        if(open < n){
            backTrack(ans,pairs+"(",open+1,close,n);
        }
        if(close < open){
            backTrack(ans,pairs+")",open,close+1,n);
        }
    }
}
public class Problem18 {
    public static void main(String[] args) {
        int n = 3;
        Solution s = new Solution();
        System.out.println("Optimal:"+s.generateParenthesisOptimal(n));
    }
}
