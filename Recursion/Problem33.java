//Problem:https://leetcode.com/problems/expression-add-operators/description/
import java.util.List;
import java.util.ArrayList;
class Solution{
  public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if(num == null || num.length()==0) return ans;
        backtrack(num,target,ans,"",0,0,0);
        return ans;
    }
    private void backtrack(String num,int target,List<String> ans,String path,int index,long eval,long prevNum){
        if(index == num.length()){
            if(eval == target) ans.add(path);
            return;
        }
        for(int i=index;i<num.length();i++){
            if(i != index && num.charAt(index) == '0') break;
             String currStr = num.substring(index,i+1);
             long curr = Long.parseLong(currStr);
             if(index == 0){
                backtrack(num,target,ans,path+currStr,i+1,curr,curr);
             }
             else{
                backtrack(num,target,ans,path+"+"+currStr,i+1,eval+curr,curr);
                backtrack(num,target,ans,path+"-"+currStr,i+1,eval-curr,-curr);
                backtrack(num,target,ans,path+"*"+currStr,i+1,eval-prevNum+prevNum*curr,prevNum*curr);
             }
        }
        return;
    }
}
public class Problem33 {
    public static void main(String[] args) {
       String num = "123";
       int target = 6;
        Solution s = new Solution();
        System.out.println("Recursive:"+s.addOperators(num, target));
    }
}
