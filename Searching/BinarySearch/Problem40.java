//problem:https://leetcode.com/problems/search-a-2d-matrix-ii/description/
package BinarySearch;

class Solution {
    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;

    }

    public boolean searchMatrixBetter(int[][] matrix, int target) {
        int m = matrix.length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == target)
                return true;
            else {
                if (binarySearch(matrix[i], target))
                    return true;
            }

        }
        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (row[mid] == target)
                return true;
            else if (row[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;

    }

    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] > target)
                column--;
            else
                row++;
        }
        return false;
    }
}

public class Problem40 {
    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 5;
        System.out.println("Brute Force:" + s.searchMatrixBruteForce(matrix, target));
        System.out.println("Better:" + s.searchMatrixBetter(matrix, target));
        System.out.println("Optimal:" + s.searchMatrixOptimal(matrix, target));
    }
}
