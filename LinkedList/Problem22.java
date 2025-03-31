//Problem:https://leetcode.com/problems/add-two-numbers/description/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode mover1 = l1;
        ListNode mover2 = l2;
        ListNode ans = new ListNode(-1);
        ListNode ansMover = ans;
        int carry = 0;
        while(mover1 != null || mover2 != null || carry != 0){
         int digit1 = mover1 != null ? mover1.val : 0;
         int digit2 = mover2 != null ? mover2.val : 0;
         int sum = digit1 + digit2+carry;
         carry = sum/10;
      ListNode temp = new ListNode(sum%10);
      ansMover.next = temp;
      ansMover = ansMover.next;

       if(mover1 != null)  mover1 = mover1.next;
       if(mover2 != null)  mover2 = mover2.next;
        }
        return ans.next;
    }
}
public class Problem22 {
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
      int[] arr1 = { 2,4,3};
      int[] arr2 = {5,6,4};
     ListNode head1= addingArrToLL(arr1);
     ListNode head2= addingArrToLL(arr2);
     
      System.out.println("Solution:"+s.addTwoNumbers(head1,head2).val);
    
  }
}
