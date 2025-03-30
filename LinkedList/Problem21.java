//Problem:http://geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public Node addOneBruteForce(Node head) {
        // code here.

        Node newHead = reverse(head);
        Node mover = newHead;
        int carry = 1;
        while (mover != null) {
            mover.data = mover.data + carry;
            if (mover.data < 10) {
                carry = 0;
                break;
            } else {
                mover.data = 0;
                carry = 1;
            }
            mover = mover.next;
        }
        if (carry == 1) {
            Node newNode = new Node(1);
            head = reverse(newHead);
            newNode.next = head;
            return newNode;
        }

        return reverse(newHead);
    }

    private Node reverse(Node head) {
        Node mover = head;
        Node prev = null;
        while (mover != null) {
            Node temp = mover.next;
            mover.next = prev;
            prev = mover;
            mover = temp;
        }
        return prev;
    }

}

public class Problem21 {
    public static Node addingArrToLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] arr = {9,9,9};
        Node head = addingArrToLL(arr);
        System.out.println("Brute Force:"+s.addOneBruteForce(head).data);
       // System.out.println("Optimal:"+s.);
    }
}