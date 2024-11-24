//Problem:https://leetcode.com/problems/rotate-image/description/
import java.util.Arrays;
class Solution {
    public int[][] rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
      for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
    }
    return matrix;
    }

}
public class Problem28 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println("Optimal Approach:"+Arrays.deepToString(s.rotate(nums)));
 
    }
}
