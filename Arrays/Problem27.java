//Problem:https://leetcode.com/problems/set-matrix-zeroes/
import java.util.Arrays;
class Solution {
    public int[][] setZeroesBruteForce(int[][] matrix) {
        int m=matrix.length;

        int n=matrix[0].length;
        System.out.println(m+" "+n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              
                if(matrix[i][j]==0 ){
                  System.out.println(i+" "+j);
                   
                    for(int k=0;k<m;k++){
                       if( matrix[k][j]!=0) 
                        matrix[k][j]=-68; //68 is just a random number
                        
                    }
                    for(int k=0;k<n;k++){
                        if( matrix[i][k]!=0) 
                        matrix[i][k]=-68;
                    }
                }
            }
        }
       for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-68){
                    matrix[i][j]=0;
                }
            }
            }
 
            return matrix;
    }

    public int[][] setZeroesBetter(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] row=new int[m];
        int[] column=new int[n];
        System.out.println(m+" "+n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              
               if(matrix[i][j]==0){
                row[i]=1;
                column[j]=1;

               }
            }
        }
       for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(column[j]==1 || row[i]==1){
                    matrix[i][j]=0;
                }
            }
            }
            return matrix;
    }
}
public class Problem27 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[][] matrix0 = {{1,1,1},{1,0,1},{1,1,1}};
       int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
    System.out.println("BruteForce Approach:"+Arrays.deepToString(s.setZeroesBruteForce(matrix0)));
    System.out.println("Better Approach:"+Arrays.deepToString(s.setZeroesBetter(matrix1)));
    
 
    }
}
