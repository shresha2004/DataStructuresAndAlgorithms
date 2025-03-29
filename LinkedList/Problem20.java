//Problem:https://leetcode.com/problems/intersection-of-two-linked-lists/description/
import java.util.HashSet;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        ListNode mover1 = headA;
        ListNode mover2 = headB;
        while(mover1 != null){
           mover2 = headB;
           while(mover2 != null){
               if(mover1 == mover2) return mover1;
               mover2 = mover2.next;
           }
           mover1 = mover1.next;
        }
       return null;
       }
       public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
       ListNode  mover = headA;
        while(mover !=null){
            set.add(mover);
            mover = mover.next;
        }
        mover = headB;
        while(mover != null){
            if(set.contains(mover)) return mover;
            mover = mover.next;
        }
        return null;
        }
}
public class Problem20 {
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
      int[] arr = { 4,1,8,4,5};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("Brute Force:"+s.getIntersectionNodeBruteForce(head, head.next.next).val);
      System.out.println("Better:"+s.getIntersectionNodeBetter(head, head.next.next).val);
  }
}
