class Solution {
    public boolean isValidBruteForce(String s) {
        int n = s.length();
        int count =0;
       while(s.contains("()") || s.contains("{}") || s.contains("[]") ){
            s = s.replace("()","")
                  .replace("{}","")
                    .replace("[]","");
                
       }
       if(s.isEmpty()) return true;
       return false;
        
    }
}
public class Problem55 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Brute Force:"+s.isValidBruteForce("(){}[]"));
    }
}
