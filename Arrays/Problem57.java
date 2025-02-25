//Problem:https://leetcode.com/problems/can-place-flowers/description/?envType=problem-list-v2&envId=array

import java.util.Arrays;
class Solution {
    public boolean canPlaceFlowersBruteForce(int[] flowerbed, int n) {
        int len = flowerbed.length;
        
        for(int i=0;i<len;i++){
            if(flowerbed[i]==0){
            boolean left = (i==0 || flowerbed[i-1] == 0);
            boolean right = (i==len-1 || flowerbed[i+1]==0);
            if(left && right){
                flowerbed[i]=1;
                n--;
                if(n==0) return true;
            }
        }
        
        
    }
    return n<=0;
}
    public boolean canPlaceFlowersOptimal(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;
        for(int i=0;i<len;i++){
            if(flowerbed[i]==0){
            boolean left = (i==0 || flowerbed[i-1] == 0);
            boolean right = (i==len-1 || flowerbed[i+1]==0);
            if(left && right){
                count++;
                i++;
             
                if(count>=0) return true;
            }
        }
        
        
    }
    return count>=0;
}
}
public class Problem57 {
      public static void main(String[] args) {
        Solution s = new Solution();
        int[] flowerbed = {1,0,0,0,1};
         int n = 1;
        System.out.println("Brute Force:"+s.canPlaceFlowersBruteForce(flowerbed, n));
        System.out.println("Optimal:"+s.canPlaceFlowersOptimal(flowerbed, n));
    }
}
