//Problem:https://leetcode.com/problems/delete-node-in-a-linked-list/description/

//Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
class Solution {
    public ListNode deleteNode(ListNode node) {
        if(node == null) return node;
        ListNode prev = null;
      while(node.next != null){
        node.val = node.next.val;
        prev = node;
        node= node .next;
      }
        prev.next = null;
        return node;
    }
}
public class Problem3 {
    public static ListNode addingArrToLL(int arr[]){
        ListNode head = new ListNode(arr[0]);
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
        int[] h = {4,5,1,9};
       ListNode head= addingArrToLL(h);
       ListNode dlt = head.next.next;
        System.out.println("Answer:"+s.deleteNode(dlt).val);
    }
}
