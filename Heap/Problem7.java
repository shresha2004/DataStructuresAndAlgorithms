//Problem:https://www.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1
import java.util.ArrayList;
import java.util.PriorityQueue;
class Solution {
    public static int kthLargestBruteForce(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer> sumArr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += arr[j];
                sumArr.add(sum);
            }
        }
       return findKthLargest(sumArr,k);
    }
    private static int findKthLargest(ArrayList<Integer> nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<k;i++)
            pq.offer(nums.get(i));
        
        for(int i=k;i<nums.size();i++){
            if(pq.peek()<nums.get(i)){
                pq.poll();
                pq.offer(nums.get(i));
            }
        }
        return pq.peek();
            
    }
}



public class Problem7 {
public static void main(String[] args) {
    int[] arr= {3, 2, 1};
    int k = 2 ;
    Solution s = new Solution();
    System.out.println("Brute force:"+s.kthLargestBruteForce(arr, k));
}
}
