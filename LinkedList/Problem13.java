//Problem:https://www.geeksforgeeks.org/problems/find-length-of-loop/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-length-of-loop
import java.util.HashSet;
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public int countNodesinLoopBruteForce(Node head) {
        // Add your code here.
        if(head == null || head.next == null ) return 0;
        HashSet<Node> set = new HashSet<>();
        Node mover = head;
         while(mover != null){
             if(!set.contains(mover)) set.add(mover);
             else return countNode(mover);
             mover = mover.next;
         }
         return 0;
        
    }
    private int countNode(Node start){
        int count = 1;
        Node mover = start.next;
        while(start != mover){
            mover = mover.next;
            count++;
        }
        return count;
        
    }
    public int countNodesinLoopOptimal(Node head) {
        // Add your code here.
        if (head == null || head.next == null)
            return 0;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
            if (fast == null || fast.next == null) {
                return 0;
            }

        }
        Node countNode = slow.next;
        int count = 1;
        while (countNode != slow) {
            countNode = countNode.next;
            count++;
        }
        return count;
    }
}

public class Problem13 {
    public static Node addingArrToLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        mover.next = head.next.next;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 25, 14, 19, 33, 10, 21, 39, 90, 58, 45 };
        Node head = addingArrToLL(arr);
        System.out.println("Brute Force:"+s.countNodesinLoopBruteForce(head));
        System.out.println("Optimal:"+s.countNodesinLoopOptimal(head));

    }
}