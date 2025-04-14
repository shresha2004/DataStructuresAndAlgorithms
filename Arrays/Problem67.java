//Problem:https://leetcode.com/problems/valid-sudoku/description/?envType=problem-list-v2&envId=array
import java.util.HashMap;
class Solution{
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Integer> rowMap = new HashMap<>();
            HashMap<Character, Integer> columnMap = new HashMap<>();

            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] != '.') {
                    char val = board[i][j];
                    rowMap.put(val, rowMap.getOrDefault(val, 0) + 1);
                    if (rowMap.get(val) > 1) return false;
                }

                
                if (board[j][i] != '.') {
                    char val = board[j][i];
                    columnMap.put(val, columnMap.getOrDefault(val, 0) + 1);
                    if (columnMap.get(val) > 1) return false;
                }
            }
        }

      
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                HashMap<Character, Integer> boxMap = new HashMap<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char val = board[boxRow + i][boxCol + j];
                        if (val == '.') continue;
                        boxMap.put(val, boxMap.getOrDefault(val, 0) + 1);
                        if (boxMap.get(val) > 1) return false;
                    }
                }
            }
        }

        return true;
    }
}
public class Problem67 {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("Brute Force:"+s.isValidSudoku(board));
       // System.out.println("Optimal:"+s.);
    }
}
