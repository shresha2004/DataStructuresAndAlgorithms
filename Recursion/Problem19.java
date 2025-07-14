//Problem:https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1
import java.util.ArrayList;
import java.util.List;
class Solution{
    public static List<String> generateBinaryStringOptimal(int n) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        
        backTrack(ans,"0",n);
        backTrack(ans,"1",n);
        return ans;
    }
    private static void backTrack(ArrayList<String> ans, String pair, int n){
        if(pair.length() == n){
            ans.add(pair);
            return;
        }
        if(pair.charAt(pair.length()-1)=='0'){
            backTrack(ans,pair+"0",n);
            backTrack(ans,pair+"1",n);
            
        }
        if(pair.charAt(pair.length()-1)=='1'){
            backTrack(ans,pair+"0",n);
        }
    }
}
public class Problem19 {
    public static void main(String[] args) {
        int n=3;
        Solution s = new Solution();
        System.out.println("Optimal:"+s.generateBinaryStringOptimal(n));
    }
}
