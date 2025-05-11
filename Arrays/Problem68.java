//Problem:https://leetcode.com/problems/three-consecutive-odds/description/?envType=problem-list-v2&envId=prshgx6i
class Solution{
 public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int count=0;
        for(int i=0;i<n;i++){

            if(count>=3) return true;
            if(arr[i]%2!=0) count++;
            else count=0;
        }
        if(count>=3) return true;
        return false;
    }
}
public class Problem68 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1,2,34,3,4,5,7,23,12};
        System.out.println("Solution:"+s.threeConsecutiveOdds(arr));
      
    }
}
