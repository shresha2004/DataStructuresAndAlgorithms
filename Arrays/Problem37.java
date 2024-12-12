 //Problem:https://www.interviewbit.com/problems/subarray-with-given-xor/
 import java.util.ArrayList;
import java.util.Arrays;
 class Solution {
    public int solveBruteForce(ArrayList<Integer> A, int B) {
        int n= A.size();
        int cnt=0;
        for(int i=0;i<n;i++){
          int  xor=0;
            for(int j=i;j<n;j++){
                xor=xor ^ A.get(j);
                if(xor==B) cnt++;
            }
            
        }
        return cnt;
    }
}
public class Problem37 {
    public static void main(String[] args) {
        Solution s=new Solution();
       ArrayList<Integer> nums =new ArrayList<>(Arrays.asList(4, 2, 2, 6, 4)) ;
    System.out.println("Brute Force Approach:"+ s.solveBruteForce(nums,6));
    }
}
