
//Problem:https://leetcode.com/problems/triangle/description/
import java.util.*;

class Solution {
    public int minimumTotalRecursive(List<List<Integer>> triangle) {

        return findMinRecursive(0, 0, triangle);
    }

    private int findMinRecursive(int row, int column, List<List<Integer>> triangle) {
        if (row == triangle.size() - 1)
            return triangle.get(row).get(column);
        int left = triangle.get(row).get(column) + findMinRecursive(row + 1, column, triangle);
        int right = triangle.get(row).get(column) + findMinRecursive(row + 1, column + 1, triangle);
        return Math.min(left, right);
    }
}

public class Problem12 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> mat = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(2)),
                        new ArrayList<>(Arrays.asList(3, 4)),
                        new ArrayList<>(Arrays.asList(6, 5, 7)),
                        new ArrayList<>(Arrays.asList(4, 1, 8, 3))));
        System.out.println("Recursion:" + s.minimumTotalRecursive(mat));
    }
}
