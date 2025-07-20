//Problem:https://leetcode.com/problems/search-a-2d-matrix/description/
package BinarySearch;
class Solution {
    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        int m = matrix.length;
    
        int n = matrix[0].length;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==target){
                return true;
            }
        }
       }
       return false;
    }
    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int m = matrix.length;
        int low = 0;
        int high = m-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(matrix[mid][0]==target) return true;
           else if(matrix[mid][0]< target){
                if(binarySearch(matrix[mid],target)) return true;
                else low = mid+1;
            }
            else high = mid-1;
        }
        return false;
        
    }

    private boolean binarySearch(int[] row,int target){
        int n = row.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low+high) >> 1;
            if(row[mid]== target) return true;
            else if(row[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}

public class Problem39 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int[][]  matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
      int target = 3;
      System.out.println("My Brute Force:"+s.searchMatrixBruteForce(matrix, target));
      System.out.println("My Optimal:"+s.searchMatrixOptimal(matrix, target));
    }
}
