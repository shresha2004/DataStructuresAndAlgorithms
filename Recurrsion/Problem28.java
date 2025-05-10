//Problem:https://leetcode.com/problems/word-search/description/
class Solution{
 public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (backtrack(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board,String word,int index,int row,int column){
        if(index == word.length()) return true;
        if(row<0||row>=board.length||column<0||column>=board[0].length||board[row][column]!=word.charAt(index)) return false;
        char temp = board[row][column];
        board[row][column]='#';
        boolean found = backtrack(board,word,index+1,row+1,column)||
                        backtrack(board,word,index+1,row-1,column)||
                        backtrack(board,word,index+1,row,column+1)||
                        backtrack(board,word,index+1,row,column-1);
            board[row][column]=temp;
            return found;
    }
}
public class Problem28 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Solution s = new Solution();
        System.out.println("Recursive:"+s.exist(board, word));
    }
}
