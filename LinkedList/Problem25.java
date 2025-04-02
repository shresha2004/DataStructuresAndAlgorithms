//Problem:https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicates-from-a-sorted-doubly-linked-list


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
    Node removeDuplicatesBruteForce(Node head){
        // Code Here.
        if(head == null) return null;
        Node mover1 = head;
        Node mover2 = head.next;
        while(mover1.next != null){
            mover2 = mover1.next;
            Node previous = mover1;
            while(mover2 != null){
                if(mover1.data == mover2.data){
                    Node temp = null;
                   if(mover2.next != null)  temp = mover2.next;
                    previous.next = temp;
                  if(temp != null)  temp.prev = previous;
                    mover2.prev = null;
                    mover2.next = null;
                    mover2 = temp;
                }
                else{
                    previous = mover2;
                    mover2 = mover2.next;
                }
            }
            
           if(mover1.next != null) mover1 = mover1.next;
          
        }
        return head;
    }
   
}
public class Problem25 {
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
        int[] arr = {1,1,1,2,3,4};
        Node head = doublyLinkedList(arr);
        System.out.println("Brute Force:"+s.removeDuplicatesBruteForce(head).next.data);
       // System.out.println("Optimal:"+s.);        
    }
}
