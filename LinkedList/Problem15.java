//Problem:https://leetcode.com/problems/odd-even-linked-list/description/
import java.util.ArrayList;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode oddEvenListBruteForce(ListNode head) {
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        int count = 1;
        ListNode mover = head;
        while(mover != null){
         if(count%2 == 0) evenList.add(mover.val);
         else oddList.add(mover.val);
         count++;
         mover = mover.next;
 
        }
        mover = head;
         for(int data : oddList){
             mover.val = data;
             mover=mover.next;
         }
         for(int data : evenList){
             mover.val = data;
             mover = mover.next;
         }
         return head;
     } 
     
     public ListNode oddEvenListOptimal(ListNode head) {
        if(head == null || head.next == null) return head;
      ListNode evenHead = head.next;
      ListNode odd = head;
      ListNode even = head.next;

      while(even !=null&& even.next != null  ){
        odd.next = odd.next.next;
        even.next = even.next.next;
        odd = odd.next;
        even = even.next;
      }
      odd.next = evenHead;
      return head;
    }


}
public class Problem15 {
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
     
      System.out.println("Brute Force:"+s.oddEvenListBruteForce(head1).next.val);
      System.out.println("Optimal:"+s.oddEvenListOptimal(head2).next.val);
  }
}
