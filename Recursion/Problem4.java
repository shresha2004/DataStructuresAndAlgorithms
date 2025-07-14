class Solution {

    void printGfg(int N) {
        // code here
        if(N==0) return;
        
         System.out.print("GFG ");
         printGfg(N-1);
    }
}
public class Problem4 {
 public static void main(String[] args) {
    Solution s= new Solution();
    s.printGfg(10);
 }   
}
