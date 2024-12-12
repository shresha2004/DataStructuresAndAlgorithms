 //Problem:https://www.interviewbit.com/problems/subarray-with-given-xor/
 import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    public int solveOptimal(ArrayList<Integer> A, int B) {
        int n= A.size();
        int cnt=0;
        int xor=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(xor,1);
        for(int i=0;i<n;i++){
          xor=xor ^ A.get(i);
          int x=xor ^ B;
          if(map.containsKey(x)){
              cnt+=map.get(x);
          }
          if(map.containsKey( xor)){
              map.put(xor,map.get(xor)+1);
          }
          else map.put(xor,1);
            
        }
        return cnt;
    }
}
public class Problem37 {
    public static void main(String[] args) {
        Solution s=new Solution();
       ArrayList<Integer> nums =new ArrayList<>(Arrays.asList(4, 2, 2, 6, 4)) ;
    System.out.println("Brute Force Approach:"+ s.solveBruteForce(nums,6));
    System.out.println("Optimal Approach:"+ s.solveOptimal(nums,6));
    }
}
