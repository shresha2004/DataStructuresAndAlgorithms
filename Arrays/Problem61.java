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
}
public class Problem61 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Brute Force:"+s.trapBruteForce(height));
    }
}
