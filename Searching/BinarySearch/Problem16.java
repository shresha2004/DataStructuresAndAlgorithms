package BinarySearch;
//I choosed question
//Problem:https://leetcode.com/problems/valid-perfect-square/description/?envType=problem-list-v2&envId=binary-search

class Solution {
    public boolean isPerfectSquareBruteForce(int num) {
        for(int i =1; i<=num;i++){
            if(i  * i == num) return true;
        }
       return false; 
    }
  
        public boolean isPerfectSquareOptimal(int num) {
           int low = 0;
           int high = num;
    
           while(low <= high){
            int mid = low+(high-low)/2;
            long check =(long) mid*mid;
            if(check == num) return true;
            else if(check > num) high = mid-1;
            else low = mid+1;
           }
           return false; 
        }
    
}
public class Problem16 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("My Brute Force:"+s.isPerfectSquareBruteForce(16));
        System.out.println("My Optimal:"+s.isPerfectSquareBruteForce(16));
    }
}
