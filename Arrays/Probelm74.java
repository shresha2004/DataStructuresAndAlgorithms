//Problem:https://leetcode.com/problems/flipping-an-image/description/
import java.util.*;
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n= image.length;
        for(int i=0;i<n;i++){
           int left = 0;
           int right = n-1;
           while(left <= right){
       
            int temp = image[i][left];
            image[i][left]=image[i][right];
            
            image[i][right]=temp;
            
            if(image[i][left]==0)
                image[i][left]=1;
            else 
                image[i][left]=0;
            if(left !=  right){
            if(image[i][right]==0)
                image[i][right]=1;
            else
                image[i][right]=0;
            }
                left++;
                right--;
            
           }
        }
        return image;
    }
}
public class Probelm74 {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        Solution s = new Solution();
        System.out.println("Solution:"+Arrays.deepToString(s.flipAndInvertImage(image)));
    }
}
