//Problem:https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list


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
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head.data == x){
            Node newHead = head.next;
            head.next =null;
            newHead.prev = null;
            head = newHead;
        }
        Node mover = head;
        Node previous = null;
        while(mover != null){
            if(mover.data == x){
                 Node temp = mover.next;
               if(previous != null) previous.next = mover.next;
               
               if(temp != null) {
                  if(previous != null) temp.prev = previous;
                   else{head = temp;
                       temp.prev = null;
                   } 
               }
                mover.next = null;
                mover.prev = null;
                mover = temp;
            }
            else{
            previous = mover;
            mover = mover.next;
            }
        }
        return head;
    }
   
}
public class Problem23 {
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
        int[] arr = { 2,2,10,8,4,2,5,2};
        Node head = doublyLinkedList(arr);
        System.out.println("Answer:"+s.deleteAllOccurOfX(head, 2).data);
    }
}
