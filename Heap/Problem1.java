//Problem:https://leetcode.com/problems/kth-largest-element-in-an-array/description/
import java.util.*;
class Heap{
    int[] hpArr;
    int capacity;
    int curSize=0;
    Heap(int capacity){
        hpArr = new int[capacity];
        this.capacity=capacity;
    }

    public void insert(int ele){
         if(curSize >= capacity) return;
        
        int i=curSize;
        hpArr[i]=ele;
        curSize++;
        while(i!=0 && hpArr[((i-1)/2)]>=hpArr[i]){
            swap(hpArr,((i-1)/2),i);
            i=((i-1)/2);
        }
    }
        public void heapify(int i){
            int left = (2*i)+1;
            int right = (2*i)+2;
            int smallest =i;
            if(left < curSize && hpArr[left]<hpArr[smallest])
                smallest=left;
            if(right < curSize && hpArr[right]<hpArr[smallest])
                smallest=right;
            if(smallest != i){
                swap(hpArr,smallest,i);
                heapify(smallest);
            }
        }
    
    public void addToHeap(int ele){
        if(ele > hpArr[0]){
           
          
            hpArr[0]=ele;
            
               heapify(0);
                }
            }
        private void swap(int[] arr,int a,int b){
            int temp = arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
        }

         public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
       for(int i=0;i<k;i++){
            pq.offer(nums[i]);
       }
        for(int i=k;i<nums.length;i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
        
    }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Heap hp = new Heap(k);
        for(int i=0;i<k;i++)
            hp.insert(nums[i]);
        for(int j=k;j<nums.length;j++)
            hp.addToHeap(nums[j]);
    return hp.hpArr[0];
    }
     public int findKthLargestUsingPq(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
       for(int i=0;i<k;i++){
            pq.offer(nums[i]);
       }
        for(int i=k;i<nums.length;i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println("Actual Heap Implementation:"+s.findKthLargest(nums, k));
        System.out.println("Using Priority Queue:"+s.findKthLargestUsingPq(nums, k));
    }
}
