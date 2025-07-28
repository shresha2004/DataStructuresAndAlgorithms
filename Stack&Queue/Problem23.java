
//Problem:https://leetcode.com/problems/sliding-window-maximum/
import java.util.*;
class Solution {
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n-k+1;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<k;j++){
                max = Math.max(max,nums[j+i]);
            }
            ans.add(max);
        }
        int[] ansArr = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ansArr[i]=ans.get(i);
        }
        return ansArr;
        
    }
     public int[] maxSlidingWindowOptimal(int[] nums, int k) {
       Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
         int[] ans = new int[n-k+1];
         int index =0;
       for(int i=0;i<n;i++){
        if(!dq.isEmpty() && dq.peekFirst()<=(i-k)) dq.removeFirst();
        while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) dq.removeLast();
        dq.addLast(i);
        if(i>=k-1){ 
            ans[index++]=nums[dq.peekFirst()];
       }
    }
    return ans;
}
}
public class Problem23 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7}; 
        int k = 3;
        System.out.println("Brute Force:"+Arrays.toString(s.maxSlidingWindowBruteForce(nums, k)));
        System.out.println("Optimal:"+Arrays.toString(s.maxSlidingWindowOptimal(nums, k)));
    }
}
