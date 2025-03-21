//Problem:https://leetcode.com/problems/middle-of-the-linked-list/description/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode middleNodeBruteForce(ListNode head) {
        ListNode temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        int mid = (count / 2) + 1;
        int checkMid = 1;
        temp = head;
        while (checkMid != mid) {
            temp = temp.next;
            checkMid++;

        }
        return temp;
    }
    public ListNode middleNodeOptimal(ListNode head) {
        if(head == null) return head;
      ListNode slow = head;
      ListNode fast = head;
      while(fast.next != null && fast.next.next != null){
        fast= fast.next.next;
        slow = slow.next;
      }
      if(fast.next == null) return slow;
      return slow.next;
    }
}

public class Problem11 {
    public static ListNode addingArrToLL(int arr[]) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

  public static void main(String[] args) {
      Solution s = new Solution();
      int[] arr = {1,2,3,4,5};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("My Brute Force:"+s.middleNodeBruteForce(head).val);
      System.out.println("Optimal:"+s.middleNodeOptimal(head).val);
  }
}
