//Problem:https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/?envType=problem-list-v2&envId=linked-list
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
    public ListNode deleteDuplicatesBruteForce(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mover = head;
        ArrayList<Integer> set = new ArrayList<>();
        while(mover != null){
           if(!set.contains(mover.val)) set.add(mover.val);
            mover = mover.next;
        }
        ListNode newNode = new ListNode(-1);
        ListNode newMover = newNode;
        for(int ele : set){
            ListNode node = new ListNode(ele);
            newMover.next = node;
            newMover = newMover.next;
        }
        return newNode.next;
    }
    public ListNode deleteDuplicatesOptimal(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        while (pointer2 != null) {
            if (pointer1.val != pointer2.val) {
                pointer1.next = pointer2;
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            } else {
                pointer2 = pointer2.next;
            }
        }
        pointer1.next = null;

        return head;
    }
}

public class Problem34 {
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
      int[] arr = {1,1,2};
     ListNode head= addingArrToLL(arr);
     
     System.out.println("Brute Force:"+s.deleteDuplicatesBruteForce(head).val);
     System.out.println("Optimal:"+s.deleteDuplicatesOptimal(head).val);
  }
}
