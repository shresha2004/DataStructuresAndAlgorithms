//Problem:https://leetcode.com/problems/palindrome-linked-list/description/
import java.util.ArrayList;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean isPalindromeBruteForce(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode mover = head;
        while (mover != null) {
            arr.add(mover.val);
            mover = mover.next;
        }
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            if (arr.get(low) != arr.get(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public boolean isPalindromeOptimal(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while(second != null){
            if(first.val != second.val){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}

public class Problem14 {
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
      int[] arr = {1,2,2,1};
     ListNode head1= addingArrToLL(arr);
     ListNode head2= addingArrToLL(arr);
     
      System.out.println("Brute Force:"+s.isPalindromeBruteForce(head1));
      System.out.println("Optimal:"+s.isPalindromeOptimal(head2));
  }
}
