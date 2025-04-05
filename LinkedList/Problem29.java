//Problem:
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;
        int length = 1;
        ListNode mover = head;
        while(mover.next != null){
            length++;
            mover = mover.next;

        }
        mover.next = head;
          k = k%length;
          if(k==0){
            mover.next = null;
            return head;
          }

        ListNode newNode = findNode(head,length - k);
        head = newNode.next;
        newNode.next =null;
        return head;
    }

    private ListNode findNode(ListNode head, int move) {
        ListNode mover = head;
        int count = 1;
        while (mover != null) {
            if (count == move)
                return mover;
            mover = mover.next;
            count++;
        }
        return mover;
    }
}

public class Problem29 {
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
        ListNode head = addingArrToLL(arr);

        System.out.println("Brute Force:" + s.rotateRight(head, 2).val);
        // System.out.println("Optimal:"+s.);
    }
}
