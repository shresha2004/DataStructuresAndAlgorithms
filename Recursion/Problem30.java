//Problem:https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
import java.util.ArrayList;
import java.util.List;
class Solution{
 public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        if(maze[0][0]==0 || maze[n-1][n-1]==0) return ans;
        boolean[][] mark = new boolean[n][n];
        backtrack(maze,0,0,"",ans,n,mark);
              
        return ans;
    }
    private void backtrack(int[][] maze,int row,int col,String str,List<String> ans,int n,boolean mark[][]){
        if(col==n-1 && row==n-1){
            ans.add(str);
            return;
        }
        mark[row][col]=true;
                if(row+1 < n && maze[row+1][col]==1&& !mark[row+1][col]){
            backtrack(maze,row+1,col,str+"D",ans,n,mark);
            
        }
         if(col-1 >= 0 && maze[row][col-1]==1&& !mark[row][col-1]){
            backtrack(maze,row,col-1,str+"L",ans,n,mark);
            
        }
        if(col+1 < n && maze[row][col+1]==1 && !mark[row][col+1]){
           
            backtrack(maze,row,col+1,str+"R",ans,n,mark);
            
        }
       

        if(row-1 >= 0 && maze[row-1][col]==1&& !mark[row-1][col]){
            backtrack(maze,row-1,col,str+"U",ans,n,mark);
            
        }
        mark[row][col]=false;
        return;
    }
}
public class Problem30 {
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        Solution s = new Solution();
        System.out.println("Recursive:"+s.ratInMaze(mat));
    }
}
