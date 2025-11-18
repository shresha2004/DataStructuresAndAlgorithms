//Problem:https://www.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1
import java.util.PriorityQueue;
class Solution {
    public int[] mergeHeapsBruteForce(int[] a, int[] b, int n, int m) {
        // your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)-> y-x);
        for(int ele : a)
            pq.offer(ele);
        for(int ele : b)
            pq.offer(ele);
            
        int[] ans = new int[m+n];
        int i=0;
        while(!pq.isEmpty())
            ans[i++]=pq.poll();
        return ans;
    }
}



public class Problem4 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int  n = 4,m = 3;
       int a[] = {10, 5, 6, 2};
       int b[] = {12, 7, 9};
       System.out.println("Brute force:"+s.mergeHeapsBruteForce(a, b, n, m));
    }
}
