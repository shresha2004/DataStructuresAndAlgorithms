//Problem:https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
import java.util.*;
class Solution{
 public int maxScoreOptimal(int[] cardPoints, int k) {
        int left = 0;
        int right = cardPoints.length-1;
        int maxPoints = 0;
        int points= 0;
        for(left = 0;left<k;left++){
            maxPoints+=cardPoints[left];
        }
        left = k-1;
        points = maxPoints;
        while(left>=0){
            points -= cardPoints[left--];
            points +=cardPoints[right--];
            maxPoints =Math.max(points,maxPoints);
        }
        return maxPoints;
    }
}
public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] cardPoints = {2,2,2};
       int k = 2;
        System.out.println("Optimal Solution:"+s.maxScoreOptimal(cardPoints, k));
    }
}
