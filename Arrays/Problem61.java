//Problem:https://leetcode.com/problems/trapping-rain-water/description/
class Solution {
    public int trapBruteForce(int[] height) {
        int n = height.length;
        int units = 0;
        if(n<0) return 0;
        for(int i =0;i<n;i++){
            int left =0,right =0;
            for(int j = 0;j<=i;j++){
                left = Math.max(height[j],left);
            }
            for(int j =i;j<n;j++){
                right = Math.max(height[j],right);
            }
            units += Math.min(left,right) - height[i];
        }
        return units;
    }

    public int trapOptimal(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int trappedWater =0;
        while(left < right){
         if(height[left]<height[right]){
             if(height[left]>= leftMax){
                 leftMax =height[left];
             }else{
                 trappedWater += leftMax - height[left];
             }
             left++;
         }
         else{
             if(height[right]>= rightMax){
                 rightMax = height[right];
             }else{
                 trappedWater += rightMax - height[right];
             }
             right--;
         }
        }
        return trappedWater;
     }
}
public class Problem61 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Brute Force:"+s.trapBruteForce(height));
        System.out.println("Optimal:"+s.trapOptimal(height));
    }
}
