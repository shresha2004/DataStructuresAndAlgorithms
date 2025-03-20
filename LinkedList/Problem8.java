//Problem:https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insert-a-node-in-doubly-linked-list


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
    Node addNode(Node head, int p, int x) {
        // Your code here
       
       int count = 0;
       Node mover = head;
       
       while(mover != null && count < p){
           mover = mover.next;
           count++;
       }
       Node next = mover.next;
       if(next == null){
           Node newNode = new Node(x);
           newNode.prev = mover;
           mover.next = newNode;
           return head;
       }
       Node newNode = new Node(x);
       newNode.prev = mover;
       newNode.next = next;
       next.prev = newNode;
       mover.next = newNode;
        return head;
    }
   
}
public class Problem8 {
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
        int[] arr = {2,4,5};
        Node head = doublyLinkedList(arr);
      
        System.out.println("Answer:"+s.addNode(head,2,6).next.next.next.data);
        
    }
}
