 //Problem:https://leetcode.com/problems/next-greater-element-ii/description/
 import java.util.*;
 class Solution{
 public int[] nextGreaterElementsBruteForce(int[] nums){
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            boolean flag = false;
            for(int j=i+1;j!=i;j++){
                if(j>=nums.length) j%=nums.length;
                if(j==i){
                    ans[i]=-1;
                    break;
                }
                if(nums[j]>nums[i]){ 
                    flag = true;
                    ans[i]= nums[j];
                break;}
            }
            if(flag == false ) ans[i]=-1;
        }
        return ans;
    }
      public int[] nextGreaterElementsOptimal(int[] nums) {
        int n =nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]) st.pop();
            if(i<n){
                if(st.isEmpty()) ans[i]=-1;
                else ans[i]=st.peek();
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
}

public class Problem15{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,3};
        System.out.println("Bruteforce :"+Arrays.toString(s.nextGreaterElementsBruteForce(nums)));
        System.out.println("Optimal :"+Arrays.toString(s.nextGreaterElementsOptimal(nums)));
        
    }
}