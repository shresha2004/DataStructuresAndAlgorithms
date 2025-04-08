//Problem:https://leetcode.com/problems/swap-nodes-in-pairs/description/?envType=problem-list-v2&envId=linked-list
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
    public ListNode swapPairsBruteForce(ListNode head) {
        ListNode mover = head;
        ArrayList<ListNode> node = new ArrayList<>();
        while (mover != null) {
            node.add(mover);
            mover = mover.next;
        }
        mover = head;
        for (int i = 0; i < node.size() - 1; i += 2) {
            int temp = node.get(i).val;
            node.get(i).val = node.get(i + 1).val;
            node.get(i + 1).val = temp;
        }
        return head;
    }
}

public class Problem31 {
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
      int[] arr = {1,2,3,4};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("Brute Force:"+s.swapPairsBruteForce(head));
     // System.out.println("Optimal:"+s.);
  }
}
