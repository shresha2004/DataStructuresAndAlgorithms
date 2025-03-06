//Problem:https://leetcode.com/problems/container-with-most-water/description/
//I choosed question
class Solution {
    public int maxAreaBruteForce(int[] height) {
        int n = height.length;
        int maxWater = 0;
        for(int i =0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int temp = (j-i) * Math.min(height[i],height[j]);
                maxWater = Math.max(maxWater,temp);
            }
        }
        return maxWater;
    }
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
        
        System.out.println("MyBruteForce:"+s.maxAreaBruteForce(height));
        System.out.println("My Optimal:"+s.maxAreaOptimal(height));
    }
}
