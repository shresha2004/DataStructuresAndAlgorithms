//Problem:https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-doubly-linked-list


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
    public Node reverseDLLBruteForce(Node head) {
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
        Node head = doublyLinkedList(arr);
        System.out.println("My Brute Force:"+s.reverseDLLBruteForce(head).data);
        
    }
}
