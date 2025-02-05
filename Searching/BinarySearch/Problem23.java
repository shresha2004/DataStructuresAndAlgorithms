package BinarySearch;
//Problem:https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=problem-list-v2&envId=binary-search

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

 public class Solution extends GuessGame {
    public int guessNumberMyBruteForce(int n) {
        for(int i = 1;i<=n;i++){
            if(guess(i) == 0) return i;
        }
        return 0;
    }

    public int guessNumberMyOptimal(int n) {
        int low =0;
        int high = n;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(guess(mid) == 0) return mid;
            if(guess(mid) == 1) low = mid+1;
            else high = mid-1;
        }
        return 0;
    }
}
public class Problem23 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int  n = 10, pick = 6;
        System.out.println("My Brute Force:"+s.guessNumberMyBruteForce(n));
        System.out.println("My Optimal:"+s.guessNumberMyOptimal(n));
        
    }
}
