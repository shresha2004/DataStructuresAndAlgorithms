//Problem:https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class Solution{
    private static HashMap<Integer,String> map = new HashMap<>();
    static{   map.put(2,"abc");
       map.put(3,"def");
       map.put(4,"ghi");
       map.put(5,"jkl");
       map.put(6,"mno");
       map.put(7,"pqrs");
       map.put(8,"tuv");
       map.put(9,"wxyz");
    }
   
   public List<String> letterCombinations(String digits) {
       List<String> ans = new ArrayList<>();
       if(digits == null || digits.length()==0   ) return ans;
       
       backtrack(digits,0,new StringBuilder(),ans);
       return ans;
   }
   private void backtrack(String digits,int index,StringBuilder str,List<String> ans){
       if(index == digits.length()){
           ans.add(str.toString());
           return;
       }
       String letters = map.get((int) (digits.charAt(index)-'0'));
       for(char c : letters.toCharArray()){
       str.append(c);
       backtrack(digits,index+1,str,ans);
       str.deleteCharAt(str.length()-1);
       }
       return;
   }
}
public class Problem26 {
    public static void main(String[] args) {
        
        Solution s = new Solution();
        System.out.println("Recursive:"+s.letterCombinations("234"));
    }
}
