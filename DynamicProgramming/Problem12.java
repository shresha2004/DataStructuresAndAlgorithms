
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

    public int minimumTotalMemoization(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] memo = new int[row][];
        for(int i=0;i<row;i++)
       {
         memo[i] = new int[triangle.get(i).size()];
            Arrays.fill(memo[i], Integer.MAX_VALUE);
       }
        int a=findMinMemoization(0,0,triangle,memo);

        return a;
    }
    private int findMinMemoization(int row,int column,List<List<Integer>> triangle,int[][] memo){
        if(memo[row][column]!=Integer.MAX_VALUE) return memo[row][column];
        if(row == triangle.size()-1 ) return triangle.get(row).get(column);
        int left = triangle.get(row).get(column)+findMinMemoization(row+1,column,triangle,memo);
        int right = triangle.get(row).get(column)+findMinMemoization(row+1,column+1,triangle,memo);
        return memo[row][column]=Math.min(left,right);
    }


      public int minimumTotalTabulation(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] tabu = new int[row][];
        for(int i=0;i<row;i++){
           tabu[i] = new int[triangle.get(i).size()];
            Arrays.fill(tabu[i],Integer.MAX_VALUE);
        }
        //Base case
        for(int i=0;i<tabu[row-1].length;i++)
            tabu[row-1][i]=triangle.get(row-1).get(i);

        for(int i=row-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int left = triangle.get(i).get(j)+tabu[i+1][j];
                int right = triangle.get(i).get(j)+tabu[i+1][j+1];
                tabu[i][j]=Math.min(left,right);
            }
        }
        return tabu[0][0];
        }
         public int minimumTotalSpaceOpti(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] spo = new int[triangle.get(row-1).size()];
        //Base case
       for(int i=0;i<spo.length;i++)
            spo[i]=triangle.get(row-1).get(i);

        for(int i=row-2;i>=0;i--){
            int[] temp = new int[triangle.get(i).size()];
            for(int j=i;j>=0;j--){
                int left = triangle.get(i).get(j)+spo[j];
                int right = triangle.get(i).get(j)+spo[j+1];
                temp[j]=Math.min(left,right);
            }
            spo =temp;
        }
        return spo[0];
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
        System.out.println("Memoization:"+s.minimumTotalMemoization(mat));
        System.out.println("Tabulation:"+s.minimumTotalTabulation(mat));
        System.out.println("Space Optimization:"+s.minimumTotalSpaceOpti(mat));
    }
}
