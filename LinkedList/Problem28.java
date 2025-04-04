//Problem:https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=problem-list-v2&envId=linked-list
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode mergeTwoListsBruteForce(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)  return null;
        ListNode mover1 = list1;
        ListNode mover2 = list2;
        ListNode head = new ListNode(-1);
        ListNode mover = head;
        while(mover1 != null && mover2 != null){
         if(mover1.val == mover2.val){
             ListNode newNode = new ListNode(mover1.val);
             mover.next = newNode;
             mover = mover.next;
             ListNode newNode2 = new ListNode(mover2.val);
              mover.next = newNode2;
             mover = mover.next;
 
             mover1= mover1.next;
             mover2 = mover2.next;
         }else if(mover1.val>mover2.val){
             ListNode newNode = new ListNode(mover2.val);
             mover.next = newNode;
             mover = mover.next;
             mover2 = mover2.next;
         }else{
             ListNode newNode = new ListNode(mover1.val);
              mover.next = newNode;
             mover = mover.next;
             mover1 =mover1.next;
         }
        }
        while(mover1 != null){
         ListNode newNode = new ListNode(mover1.val);
         mover.next = newNode;
         mover = mover.next;
         mover1 = mover1.next;
        }
        while(mover2 != null){
         ListNode newNode = new ListNode(mover2.val);
         mover.next = newNode;
         mover = mover.next;
         mover2 = mover2.next;
        }
        return head.next;
     }
}
public class Problem28 {
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
      int[] arr = {1,2,4 };
      int[] arr2 = { 1,3,4};
     ListNode head1= addingArrToLL(arr);
     ListNode head2= addingArrToLL(arr2);
     
      System.out.println("Brute Force:"+s.mergeTwoListsBruteForce(head1, head2).val);
     // System.out.println("Optimal:"+s.);
  }
}
