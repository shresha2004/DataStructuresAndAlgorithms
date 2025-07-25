
//Problem:https://leetcode.com/problems/maximal-rectangle/description/
import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m =matrix.length;
        int n = matrix[0].length;
       int[] heights = new int[n]; 
 int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
              maxArea = Math.max(maxArea, lHist(heights));
        }
   
        return maxArea;
    }

    private int lHist(int[] heights){
         Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && curr < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
public class Problem22 {
    public static void main(String[] args) {
        Solution s = new Solution();
       char[][] matrix = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}}
        System.out.println(s.);
    }
}
