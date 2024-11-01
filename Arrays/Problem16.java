//Problem:https://leetcode.com/problems/maximum-subarray/description/
class Solution {
    //BruteForce
    public int maxSubArrayBruteForce(int[] nums) {
        int n=nums.length;
        int i,j;
        int maxSum=nums[0];
        int sum=0;
        for(i=0;i<n;i++){
            sum=0;
            for(j=i;j<n;j++){
                sum+=nums[j];
                 maxSum=maxEle(sum,maxSum);
            }
           
        }
        return maxSum;
        
    }

    //Kadane's Algorithm (Optimal)
    public int maxSubArrayOptimal(int[] nums) {
        int n=nums.length;
        int i;
        int maxSum=nums[0];
        int sum=0;
        for(i=0;i<n;i++){
            sum+=nums[i];
            maxSum=maxEle(sum, maxSum);
            if(sum<0) sum=0;
        }
        return maxSum;
        
    }

    public int maxEle(int a,int b){
        if(a>b) return a;
        return b;
    }
}
public class Problem16 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Brute force:"+s.maxSubArrayBruteForce(nums));
        System.out.println("Optimal:"+s.maxSubArrayOptimal(nums));
    }
}
