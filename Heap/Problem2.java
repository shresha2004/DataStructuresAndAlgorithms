//Problem:https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
import java.util.*;
class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int  i=0;i<k;i++){
            pq.offer(arr[i]);
        }
        for(int j=k;j<arr.length;j++){
            if(pq.peek()>arr[j]){
                pq.poll();
                pq.offer(arr[j]);
            }
        }
        return pq.peek();
    }
}
public class Problem2 {
   public static void main(String[] args) {
   int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
   int k = 4;
   Solution s = new Solution();
   System.out.println("Solution:"+s.kthSmallest(arr, k));
   } 
}
