//Problem:https://leetcode.com/problems/distribute-candies/description/?envType=problem-list-v2&envId=hash-table
import java.util.*;
class Solution {
    public int distributeCandies(int[] candyType) {
       HashSet<Integer> set = new HashSet<>();
       for(int e : candyType){
        set.add(e);
       }
      if(set.size()<=(candyType.length)/2) return set.size();
      else return candyType.length/2;
    }
}
public class Problem11{
 public static void main(String[] args) {
    int[] candyType = {1,1,2,2,3,3};
    Solution s = new Solution();
    System.out.println("Solution:"+s.distributeCandies(candyType));
 }
}