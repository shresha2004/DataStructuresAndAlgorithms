import java.util.PriorityQueue;

class Solution {
    public static int minCost(int[] arr) {
        // code here
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
       for(int ele : arr)
        pq.offer(ele);
        
        int cost =0;
        while(pq.size()>1){
            int a =pq.poll();
            int b =pq.poll();
            int sum = a+b;
            cost+=sum;
            pq.offer(sum);
        }
        return cost;
    }
}
public class Problem5{
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {4, 3, 2, 6};
        System.out.println("Solution:"+s.minCost(arr));
    }
}