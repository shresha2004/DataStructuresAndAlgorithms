//Problem:https://leetcode.com/problems/partition-list/description/?envType=problem-list-v2&envId=linked-list
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
    public ListNode partitionBruteForce(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
       ArrayList<Integer> before = new ArrayList<>();
       ArrayList<Integer> after = new ArrayList<>();
       while(head != null){
          if(head.val <x) before.add(head.val);
          else after.add(head.val);
          head = head.next;
       }
       ListNode newLL = new ListNode(0);
       ListNode newMover = newLL;
       for(int ele : before){
        ListNode temp = new ListNode(ele);
        newMover.next = temp;
        newMover = newMover.next;
       }
       for(int ele : after){
        ListNode temp = new ListNode(ele);
        newMover.next = temp;
        newMover = newMover.next;
       }
       return newLL.next;
    }
    public ListNode partitionOptimal(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
       ListNode beforeX = new ListNode(0);
       ListNode afterX = new ListNode(0);
       ListNode before = beforeX;
       ListNode after = afterX;
       while(head != null){
        if(head.val < x){
            beforeX.next =head;
            beforeX=beforeX.next;
        }
        else{
            afterX.next = head;
            afterX = afterX.next;
        }
        head= head.next;

       }
       beforeX.next = after.next;
       afterX.next = null;
        return before.next;
    }
}
public class Problem35 {
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
      int[] arr = {1,4,3,2,5,2};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("Brute Force:"+s.partitionBruteForce(head, 3).val);
      System.out.println("Optimal:"+s.partitionOptimal(head, 3).val);
  }
}
