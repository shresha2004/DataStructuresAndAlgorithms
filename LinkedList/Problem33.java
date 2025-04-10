//Problem:https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=problem-list-v2&envId=linked-list
import java.util.HashMap;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode deleteDuplicateBruteForce(ListNode head) {
        if (head == null || head.next == null)
            return head;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode mover = head;
        while (mover != null) {
            map.put(mover.val, map.getOrDefault(mover.val, 0) + 1);
            mover = mover.next;
        }
        System.out.println(map);
        mover = head;
        ListNode newHead = new ListNode(-1);
        ListNode newMover = newHead;
        while (mover != null) {
            if (map.get(mover.val) <= 1) {
                ListNode newNode = new ListNode(mover.val);
                newMover.next = newNode;
                newMover = newMover.next;
            }
            mover = mover.next;
        }
        return newHead.next;
    }
}

public class Problem33 {
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
      int[] arr = {1,2,3,3,4,4,5};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("Brute Force:"+s.deleteDuplicateBruteForce(head).val);
     // System.out.println("Optimal:"+s.);
  }
}
