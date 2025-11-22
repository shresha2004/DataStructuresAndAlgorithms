//Problem:https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
import java.util.*;
class Node{
    int i,j,value;
    Node(int value,int i,int j){
        this.i=i;
        this.j=j;
        this.value=value;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.value-b.value);
        int k = nums.size();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            pq.offer(new Node(nums.get(i).get(0),i,0));
            max = Math.max(max,nums.get(i).get(0));
        }
        min = pq.peek().value;
        int ansStart = min;
        int ansEnd = max;
        int range = max-min;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int value = cur.value;
            int i=cur.i;
            int j=cur.j+1;
           

           
            if(j<nums.get(i).size()){
                pq.offer(new Node(nums.get(i).get(j),i,j));
                max = Math.max(nums.get(i).get(j),max);
                 min = pq.peek().value;
            }
            else break;
            
            if(max-min < range ||(max-min == range && min <ansStart)){
                ansStart = min;
                ansEnd = max;
                range = max-min;
            }
        }
        return new int[] {ansStart,ansEnd};
    }
}
public class Problem10 {
public static void main(String[] args) {
      List<List<Integer>> nums = new ArrayList<>();

        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        Solution s = new Solution();
        System.out.println("Solution:"+Arrays.toString(s.smallestRange(nums)));

}
}
