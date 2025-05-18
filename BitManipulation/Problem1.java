//Problem:https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
import java.util.ArrayList;
class Solution{
 static boolean checkKthBit(int n, int k) {
        // Your code here
        ArrayList<Integer> lst = new ArrayList<>();
        while(n !=0){
            if(n%2== 1) lst.add(1);
            else lst.add(0);
           
            n=n/2;
        }
        if(k>=lst.size()) return false;
        return lst.get(k)==1;
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 4 ;
        int k = 0;
        System.out.println("Brute Force:"+s.checkKthBit(num,k));
    }
}
