//Problem:https://leetcode.com/problems/word-break/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
class Solution{

 public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<String> set = new HashSet<>(wordDict);
       boolean[] arr = new boolean[s.length()+1];
       arr[0]=true;
       for(int i=1;i<=s.length();i++){
        for(int j=0;j<i;j++){
            if(arr[j] && set.contains(s.substring(j,i))){
                arr[i]=true;
                break;
            }   
        }
       }
       return arr[s.length()];
    }
}
public class Problem21 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "leetcode";
        System.out.println("Optimal:"+s.wordBreak(ss, new ArrayList<>(Arrays.asList("leet","code"))));
    }
}
