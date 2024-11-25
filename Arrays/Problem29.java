//Problem:https://leetcode.com/problems/spiral-matrix/description/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> spiralOrderOptimal(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int top=0;
        int bottom=m-1;
        int right=n-1;
        List<Integer> ans=new ArrayList<>();

    while(top <= bottom && left<=right){
        for(int i=left;i<=right;i++){
            ans.add(matrix[top][i]);
        }
        top++;
        for(int i=top;i<=bottom;i++){
            ans.add(matrix[i][right]);
        }
        right--;
        if(top<=bottom){
        for(int i=right;i>=left;i--){
            ans.add(matrix[bottom][i]);
        }
        }
        bottom--;
        if(left<=right){
        for(int i=bottom;i>=top;i--){
            ans.add(matrix[i][left]);
        }
        }
        left++;
    }
    return ans;
    }
}
public class Problem29 {
     public static void main(String[] args) {
        Solution s=new Solution();
       int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println("Optimal Approach:"+(s.spiralOrderOptimal(nums)));
 
    }
}
