//Problem:https://leetcode.com/problems/container-with-most-water/description/
//I choosed question
class Solution {
    public int maxAreaOptimal(int[] height) {
        int n = height.length;
        int left = 0,right = n-1;
        int maxWater = 0;
        while(left < right){
            if(height[left] < height[right]){
               
                int temp = (right -left) * height[left];
                maxWater = Math.max(temp,maxWater);
                left++;
            }
            else {
                int temp = (right -left) * height[right];
                maxWater = Math.max(temp,maxWater);
                right--;
            }

        }
        return maxWater;
    }
}
public class Problem62 {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("My Optimal:"+s.maxAreaOptimal(height));

    }
}
