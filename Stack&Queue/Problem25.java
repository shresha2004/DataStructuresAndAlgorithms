//Problem:https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
class Solution {
    public int celebrityBruteForce(int mat[][]) {
        // code here
        int n = mat.length;
        if(n==0) return -1;
        int[] knowMe = new int[n];
        int[] iKnow = new int[n];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(i==j) continue;
                if( mat[i][j]==1){
                 knowMe[j]+=1;
                 iKnow[i]+=1;
                }
            }
            

        }
        
        for(int i=0;i<n;i++){
                if(knowMe[i]==n-1 && iKnow[i]==0) return i;
            }
        return -1;
    }

     public int celebrityOptimal(int mat[][]) {
        // code here
        int n =mat.length;
      int top = 0;
      int down = n-1;
      
      while(top < down){
          if(mat[top][down]==1) top++;
          else if(mat[down][top]==1) down--;
          else{
              top++;
              down--;
          }
      }
      if(top>down) return -1;
      for(int i=0;i<n;i++){
          if(top==i) continue;
          if(mat[top][i]==1 || mat[i][top]==0) return -1;
      }
      return top;
    }
}
public class Problem25 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[][] mat = {{1, 1, 0}, {0, 1, 0}, {0, 1, 1}};
        System.out.println("Brute Force:"+s.celebrityBruteForce(mat));
        System.out.println("Optimal:"+s.celebrityOptimal(mat));
    }
}
