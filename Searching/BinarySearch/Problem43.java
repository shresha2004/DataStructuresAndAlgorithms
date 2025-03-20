//Problem:https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/?envType=problem-list-v2&envId=binary-search
package BinarySearch;
class Solution {
    public char nextGreatestLetterBruteForce(char[] letters, char target) {
        int n = letters.length;
        char ans = letters[0];
        for(int i=0;i<n;i++){
            if(letters[i]>target){
                return letters[i];
            }
        }
        return ans;
    }

    public char nextGreatestLetterOptimal(char[] letters, char target) {
        int n = letters.length;
     if(target >= letters[n-1] || target < letters[0])  return letters[0];
       int low = 0;
       int high = n-1;
       while(low <= high){
        int mid = (low+high)/2;
        if(letters[mid]<=target){
            low = mid+1;
        }else
        high = mid-1;

       }
       return letters[low];
    }
}
public class Problem43 {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[] letters = {'c','f','j'};
        System.out.println("Brute Force:"+s.nextGreatestLetterBruteForce(letters, 'a'));
        System.out.println("Optimal:"+s.nextGreatestLetterOptimal(letters, 'a'));
    }
}
