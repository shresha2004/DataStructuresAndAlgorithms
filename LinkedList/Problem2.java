//Problem:https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-insertion

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        // code here
        if(head == null) return new Node(x);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(x);
        temp.next= newNode;
        return head;
    }
}
public class Problem2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Answer:"+s.insertAtEnd(null, 5).data);
    }
}
