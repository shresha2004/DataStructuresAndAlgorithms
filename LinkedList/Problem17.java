//Problem:https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode deleteMiddleBruteForce(ListNode head) {
        if(head.next == null) return null;
     ListNode mover = head;
     int count = 1;
     while(mover.next != null)   
     {
        mover = mover.next;
        count++;
     }
     int mid = (count/2);
    mover = head;
     count =1;
    while(count < mid){
        mover = mover.next;
        count++;
    }
    ListNode temp = mover.next;
    mover.next = mover.next.next;
    temp.next = null;
    return head;
    }

    public ListNode deleteMiddleOptimal(ListNode head) {
        if(head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast.next != null && fast.next.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next == null) slow = prev;
        ListNode temp = slow.next;
        slow.next =slow.next.next;
        temp.next = null;
        return head; 
    }
}
public class Problem17 {
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
      int[] arr = {1,2,3,4};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("My Brute Force:"+s.deleteMiddleBruteForce(head).val);
      System.out.println("My Optimal:"+s.deleteMiddleOptimal(head).val);
  }
}
