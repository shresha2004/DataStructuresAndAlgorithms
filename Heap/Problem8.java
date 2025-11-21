//Problem:https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
      val = x;
      next=null;
      }
  }
 
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<k;i++){
            if(lists[i] != null)
                pq.offer(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode mover = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            mover.next = temp;
            mover=mover.next;
            if(temp.next != null){
                pq.offer(temp.next);
            }
        }
        return dummy.next;
    }
}
public class Problem8 {
     public static ListNode addingArrToLL(int arr[]){
        ListNode head = new  ListNode(arr[0]);
        ListNode mover = head;
        for(int i=1;i<arr.length;i++){
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover=temp;
        }
        return head;  
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,4,5 };
        int[] arr2 = {1,3,4 };
        int[] arr4 = {1,9,70 };
       ListNode head1= addingArrToLL(arr);
       ListNode head2= addingArrToLL(arr2);
       ListNode head3= addingArrToLL(arr2);
       ListNode[] lists = {head1,head2,head3};
        System.out.println("Solution:"+s.mergeKLists(lists).val);
       
    }
}
