import java.util.*;
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ls = new ArrayList<>();
        int maxCandies = Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>maxCandies){
                maxCandies = candies[i];
            }
        }
        for(int candy : candies){
            if(candy+extraCandies >= maxCandies) ls.add(true);
            else ls.add(false);
        }
        return ls;
    }
}
public  class Problem69 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println("Solution:"+s.kidsWithCandies(candies, extraCandies));
    }
}
