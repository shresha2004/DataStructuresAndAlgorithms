class Solution {
    int maxLenBruteForce(int arr[]) {
        // code here
        int n=arr.length;
        int maxLength=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+arr[j];
                if(sum==0){
                    maxLength=Math.max(j-i+1,maxLength);
                }
            }
        }
        return maxLength;
    }
}
public class Problem36 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {-1,0,1,2,-1,-4};
    System.out.println("Brute Force Approach:"+ s.maxLenBruteForce(nums));
    // System.out.println("Better Approach:"+ s.threeSumBetter(nums).toString());
    // System.out.println("Optimal Approach:"+ s.threeSumBetter(nums).toString());
    }
}
