//Problem:https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-doubly-linked-list

import java.util.Stack;
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
    public Node reverseDLLMyBruteForce(Node head) {
        // Your code here
        Node tail = head ;
        Node start = head;
        int count = 1;
        while(tail.next != null){
            tail = tail.next;
            count++;
        }
        int low = 0;
        int high = count;
        while( low < high){
            int temp = start.data;
            start.data = tail.data;
            tail.data = temp;
            tail = tail.prev;
            start = start.next;
            low++;
            high--;
        }
        return head;
    }

    public Node reverseDLLBruteForce(Node head) {
        // Your code here
        Stack<Integer> stk = new Stack<>();
        Node temp = head;
        while(temp!= null){
            stk.push(temp.data);
            temp = temp.next;
        }
        
        Node add = head;
        while(add != null){
            add.data = stk.pop();
            add = add.next;
        }
        return head;
    }
    public Node reverseDLLMyOptimal(Node head) {
        // Your code here
     Node mover = head;
     Node updatedHead = null;
     while(mover != null){
         Node temp = mover.next;
         mover.next = mover.prev;
         mover.prev = temp;
         updatedHead = mover;
         mover = temp;
     }
     return updatedHead;
    }
    public Node reverseDLLOptimal(Node head) {
        if(head == null || head.next == null) return head;
        // Your code here
     Node mover = head;
     Node temp = null;
     while(mover != null){
         temp = mover.prev;
         mover.prev = mover.next;
         mover.next = temp;
        
         mover = mover.prev;
     }
     return temp.prev;
    }
    
   
}
public class Problem10 {
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
        int[] arr = {3,4,5};
        Node head1 = doublyLinkedList(arr);
        Node head2 = doublyLinkedList(arr);
        Node head3 = doublyLinkedList(arr);
        Node head4 = doublyLinkedList(arr);
        System.out.println("My Brute Force:"+s.reverseDLLMyBruteForce(head1).data);
        System.out.println("Brute Force:"+s.reverseDLLMyBruteForce(head2).data);
        System.out.println("My Optimal:"+s.reverseDLLMyOptimal(head3).data);
        System.out.println("Optimal:"+s.reverseDLLMyBruteForce(head4).data);
        
    }
}
