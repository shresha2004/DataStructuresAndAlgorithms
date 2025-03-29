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
       public ListNode getIntersectionNodeBetter1(ListNode headA, ListNode headB) {
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
        public ListNode getIntersectionNodeBetter2(ListNode headA, ListNode headB) {

            int lengthA = findLength(headA);
            int lengthB = findLength(headB);
    
            if (lengthA > lengthB) {
                int diff = lengthA - lengthB;
                ListNode newHeadA = moveNode(headA, diff);
                return verify(newHeadA,headB);
             
            } else {
                int diff = lengthB - lengthA;
                ListNode newHeadB = moveNode(headB,diff);
                return verify(headA,newHeadB);
            }
         
        }
        private ListNode verify(ListNode moverA,ListNode moverB){
            while(moverA != null && moverB != null){
                if(moverA == moverB) return moverA;
                moverA = moverA.next;
                moverB = moverB.next;
            }
            return null;
        }
    
        private ListNode moveNode(ListNode mover, int count){
            while(count > 0){
                mover = mover.next;
                count--;
            }
            return mover;
        }
        private int findLength(ListNode mover) {
            int count = 0;
            while (mover != null) {
                count++;
                mover = mover.next;
            }
            return count;
        }
        public ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode moverA = headA;
            ListNode moverB = headB;
    
            while(moverA != moverB){
                moverA = moverA==null?headA:moverA.next;
                moverB = moverB==null?headB:moverB.next;
            }
            return moverA;
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
      System.out.println("Better1:"+s.getIntersectionNodeBetter1(head, head.next.next).val);
      System.out.println("Better2:"+s.getIntersectionNodeBetter2(head, head.next.next).val);
      System.out.println("Optimal:"+s.getIntersectionNodeOptimal(head, head.next.next).val);
  }
}
