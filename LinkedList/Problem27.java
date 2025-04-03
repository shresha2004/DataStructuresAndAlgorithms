//Problem:https://leetcode.com/problems/remove-linked-list-elements/description/?envType=problem-list-v2&envId=linked-list
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode removeElementsBruteForce(ListNode head, int val) {
        if(head == null) return head;
        if(head.val == val) head = head.next;
        ListNode mover = head;
        ListNode previous = null;
        while(mover != null){
            if(mover.val == val){
                ListNode temp = mover.next;
                if(previous != null) previous.next = mover.next;
                else{
                    head = temp;
                }
                mover = temp;
            }else{
                previous = mover;
                mover = mover.next;
            }
        }
        if(previous == null) return null;
        return head;
    }
}
public class Problem27 {
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
      int[] arr = { 1,2,6,3,4,5,6};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("Brute Force:"+s.removeElementsBruteForce(head,6 ).val);
     // System.out.println("Optimal:"+s.);
  }
}
