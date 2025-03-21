//Problem:https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-node-in-doubly-linked-list


class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}

class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if(x==1){
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
            return head;
        }
        int count = 1;
        Node mover = head;
        
        while(count < x){
            mover = mover.next;
            count++;
        }
        
        Node previous = mover.prev;
        if(mover.next == null){
            previous.next = null;
            mover.prev = null;
            return head;
        }
        Node next = mover.next;
        previous.next = next;
        next.prev = previous;
        mover.prev=null;
        mover.next = null;
        return head;
    }
   
}
public class Problem9 {
     public static Node doublyLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            temp.prev =mover;
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,3,4};
        int x = 3;
        Node head = doublyLinkedList(arr);
        System.out.println("Answer:"+s.deleteNode(head, x).data);
        
    }
}
