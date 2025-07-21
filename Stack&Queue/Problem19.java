//Problem:https://leetcode.com/problems/sum-of-subarray-ranges/description
import java.util.Arrays;
import java.util.Stack;
class Solution {
    public long subArrayRangesBruteForce(int[] nums) {
        int n = nums.length;
        long total =0;
        for(int i=0;i<n;i++){
            for(int j=nums.length-1;j>=i;j--){
                int k = i;
                int large = nums[i];
                int small = nums[i];
                while(k<=j){
                    if(nums[k]>large) large=nums[k];
                    if(nums[k]<small) small = nums[k];
                    k++;
                }
                total+=(large-small);
            }
        }
        return total;
    }

    public long subArrayRangesOptimal(int[] nums) {
        int n = nums.length;
       int[] nse = findNSE(nums,n);
       int[] pse = findPSE(nums,n);
       int[] nle = findNLE(nums,n);
       int[] ple =findPLE(nums,n);
        long sumOfMin = 0;
        long sumOfMax = 0;
       for(int i=0;i<n;i++){
        int left1 = i - pse[i];
        int right1 = nse[i]-i;
        long contri1 =(long) left1*right1*nums[i];
        sumOfMin += contri1;

       
       }

       for(int i=0;i<n;i++){
         int left2 = i - ple[i];
        int right2= nle[i]-i;
        long contri2 = (long)left2*right2*nums[i];
        sumOfMax += contri2;
       }
     
        return sumOfMax-sumOfMin;
    }
    private int[] findNSE(int[] nums,int n){
       Stack<Integer> st = new Stack<>() ;
        int[] nse = new int[n];
       for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && nums[st.peek()]>=nums[i]) st.pop();
        if(st.isEmpty()) nse[i]=n;
        else nse[i]=st.peek();
        st.push(i);
       }
       return nse;
    }

    private int[] findPSE(int[] nums,int n){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]) st.pop();
            if(st.isEmpty()) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        return pse;
    }

    private int[] findNLE(int[] nums,int n){
        Stack<Integer> st = new Stack<>();
        int[] nle = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]) st.pop();
            if(st.isEmpty()) nle[i]=n;
            else nle[i]=st.peek();
            st.push(i);

        }
        return nle;
    }
    private int[] findPLE(int[] nums,int n){
       Stack<Integer> st = new Stack<>();
       int[] ple = new int[n];

       for(int i=0;i<n;i++){
        while(!st.isEmpty() && nums[st.peek()]<nums[i]) st.pop();
        if(st.isEmpty()) ple[i]=-1;
        else ple[i]= st.peek();
        st.push(i);
       }
       return ple;
    }
    
}



public class Problem19 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        System.out.println("Brute Force:"+s.subArrayRangesBruteForce(nums));
        System.out.println("Optimal:"+s.subArrayRangesOptimal(nums));
    }
}
