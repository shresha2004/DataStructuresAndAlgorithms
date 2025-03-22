//Problem:https://leetcode.com/problems/reverse-linked-list/description/
import java.util.Stack;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode reverseListBruteForce(ListNode head) {
        Stack<Integer>  stk = new Stack<>();
        ListNode mover = head;
        while(mover != null){
           stk.push(mover.val);
           mover= mover.next;
        }
        mover = head;
        while(mover != null){
           mover.val = stk.pop();
           mover= mover.next;
        }
        return head;
       }

       public ListNode reverseListMyOptimal(ListNode head) {
        ListNode mover = head;
        ListNode change = null;
        while(mover != null){
         ListNode next = mover.next;
         mover.next = change;
         change = mover;
         mover = next;
   
        }
       return change;
       }

       public ListNode reverseListRecurrsive(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseListRecurrsive(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    
        }
}
public class Problem12 {
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
      int[] arr = {1,2,3,4,5};
      
     ListNode head1= addingArrToLL(arr);
     ListNode head2= addingArrToLL(arr);
     ListNode head3= addingArrToLL(arr);
     
      System.out.println("Brute Force:"+s.reverseListBruteForce(head1).val);
      System.out.println("My Optimal:"+s.reverseListMyOptimal(head2).val);
      System.out.println("Recurrsive:"+s.reverseListRecurrsive(head3).val);
  }
}
