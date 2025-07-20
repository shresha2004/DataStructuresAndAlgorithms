//Problem:https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/?envType=problem-list-v2&envId=binary-search
package BinarySearch;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                arr.add(matrix[i][j]);
        }
        Collections.sort(arr);
        return arr.get(k-1);
    }
 
}

public class Problem44 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println("Brute Force:"+s.kthSmallest(matrix, 8));

    }
}
