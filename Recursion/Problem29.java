//Problem:https://leetcode.com/problems/n-queens/description/
import java.util.List;
import java.util.ArrayList;
class Solution{
 public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtrack(board,n,ans,0);
        return ans;
    }
    private void backtrack(char[][] board,int n,List<List<String>> ans,int col){
        if(col==board.length){
            ans.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++){
        if(validate(board,col,row)){
            board[row][col]='Q';
            backtrack(board,n,ans,col+1);
            board[row][col]='.';
        }
        }
        return;
    }
    private boolean validate(char[][] board,int col,int row){
        int dubCol = col;
        int dubRow = row;
        while(dubCol>=0 && dubRow>=0){
            if(board[dubRow][dubCol]=='Q') return false;
            dubCol--;
            dubRow--;
        }
        dubCol = col;
        dubRow= row;
        while(dubCol>=0 && dubRow<board.length){
            if(board[dubRow][dubCol]=='Q') return false;
            dubRow++;
            dubCol--;
        }
        dubCol = col;
        dubRow = row;
        while(dubCol >= 0){
            if(board[dubRow][dubCol]=='Q') return false;
            dubCol--;
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
                res.add(s);
        }
        return res;
    }
}
public class Problem29 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Recursive:"+s.solveNQueens(5));
    }
}
