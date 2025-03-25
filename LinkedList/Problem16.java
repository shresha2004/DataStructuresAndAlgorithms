//Problem:https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode removeNthFromEndBruteForce(ListNode head, int n) {
        if(head.next == null ) return null;
        if(head.next.next == null && n==1){
            head.next = null;
            return head;
        }
        ListNode mover = head;
        int count = 1;
        while( mover.next != null){
            mover = mover.next;
            count++;
        }
        if(count == n)return head.next;
        int NthNode = count - n;
        mover = head;
        count = 1;
        System.out.println(NthNode);
        while(count < NthNode){
            mover = mover.next;
            count++;
        }
         ListNode temp = mover.next;
        mover.next = mover.next.next;
       
        temp.next = null;
        return head;
    }

    public ListNode removeNthFromEndOptimal(ListNode head, int n) {
        if(head.next == null) return null;
        if(head.next.next == null && n==1){
            head.next = null;
            return head;
        }
       ListNode fast = head;
       int count = 1;
       while(count <= n ){
        fast = fast.next;
        count++;
       }
       if(fast == null) return head.next;
       ListNode slow = head;
       while(fast.next != null){
        slow = slow.next;
        fast = fast.next;
       }
       ListNode temp = slow.next;
       slow.next = slow.next.next;
       temp.next = null;
       return head;
    }
}
public class Problem16 {
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
      int[] arr = { 1,2,3,4,5};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("My Brute Force:"+s.removeNthFromEndBruteForce(head, 5).val);
      System.out.println("Optimal:"+s.removeNthFromEndOptimal(head, 5).val);
  }
}
