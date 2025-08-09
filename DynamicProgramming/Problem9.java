class Solution {
    public int uniquePathsRecursive(int m, int n) {
        return countPathsRecursive(m-1,n-1);
    }
    private int countPathsRecursive(int row,int column){
        if(row == 0 && column == 0) return 1;
        if(row<0 || column <0) return 0;
        int left = countPathsRecursive(row-1,column);
        int right = countPathsRecursive(row,column-1);
        return left + right;
    }
}
public class Problem9 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 3;
        int n= 2;
        System.out.println("Recursive:"+s.uniquePathsRecursive(m, n));
    }
}
