//Problem:https://leetcode.com/problems/hand-of-straights/description/
import java.util.TreeMap;
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       int n=hand.length;
       if(n%groupSize != 0)  return false;
      TreeMap<Integer,Integer> map = new TreeMap<>();
      for(int i=0;i<n;i++){
        map.put(hand[i],map.getOrDefault(hand[i],0)+1);
      }
      while(!map.isEmpty()){
        int start = map.firstKey();
        int count = map.get(start);
        for(int i=0;i<groupSize;i++){
            int card =start+i;
            if(!map.containsKey(card)  || map.get(card)<count) return false;

            if(map.get(card)==count) map.remove(card);
            else map.put(card,map.get(card)-count);
        }
      }
      return true;
    }
}



public class Problem15 {
        public static void main(String[] args) {
          int[]  hand = {1,2,3,6,2,3,4,7,8};
          int groupSize = 3;
          Solution s = new Solution();
          System.out.println("Solution:"+s.isNStraightHand(hand, groupSize));

        }
}
