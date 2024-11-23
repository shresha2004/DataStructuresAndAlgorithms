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
    public int[][] setZeroesOptimal(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int col0=1;
      
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              
               if(matrix[i][j]==0){
               matrix[i][0]=0;
               if(j!=0)
                matrix[0][j]=0;
                else col0=0;
                

               }
            }
        }
       for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=1;j--){
                
                   if(matrix[0][j] == 0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                   }
                
            }
            if(col0==0){
                matrix[i][0]=0;
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
       int[][] matrix2 = {{1,1,1},{1,0,1},{1,1,1}};
    System.out.println("BruteForce Approach:"+Arrays.deepToString(s.setZeroesBruteForce(matrix0)));
    System.out.println("Better Approach:"+Arrays.deepToString(s.setZeroesBetter(matrix1)));
    System.out.println("Optimal Approach:"+Arrays.deepToString(s.setZeroesOptimal(matrix2)));
    
 
    }
}
