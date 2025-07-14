//Problem:https://leetcode.com/problems/palindrome-partitioning/description/
import java.util.List;
import java.util.ArrayList;
class Solution{
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s,ans,new ArrayList<>(),0);
        return ans;
    }
    private void backtrack(String s,List<List<String>> ans,ArrayList<String> checkPalin,int index){
        if(index == s.length()){
             ans.add(new ArrayList<>(checkPalin));
            return;
        }
        for(int i=index;i<s.length();i++){
        if(checkPalindrome(s,index,i)){
        checkPalin.add(s.substring(index,i+1));
        backtrack(s,ans,checkPalin,i+1);
        checkPalin.remove(checkPalin.size()-1);
       }
        }
        return;
    }
    private boolean checkPalindrome(String check,int left,int right){
        
        while(left <= right){
            if(check.charAt(left) != check.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
public class Problem27 {
    public static void main(String[] args) {
        String ss= "aab";
        Solution s = new Solution();
        System.out.println("Recursive:"+s.partition(ss));
    }
}
