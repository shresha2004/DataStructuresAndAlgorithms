//Problem:https://leetcode.com/problems/rank-transform-of-an-array/description/
import java.util.*;
class Node{
    int val;
    int index;
    
    Node(int val,int index){
        this.index =index;
        this.val = val;
      
    }
}
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.val-b.val);
      
        for(int i=0;i<n;i++){
           
            pq.offer(new Node(arr[i],i));
        }
        int rank = 1;
        while(!pq.isEmpty()){
            Node cur = pq.poll(); 
            arr[cur.index]=rank;
            if(!pq.isEmpty() && cur.val != pq.peek().val) rank++;
        }
        return arr;
    }
}
public class Problem13 {
public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr = {37,12,28,9,100,56,80,5,12};
    System.out.println("Solution:"+Arrays.toString(s.arrayRankTransform(arr)));
}
}
