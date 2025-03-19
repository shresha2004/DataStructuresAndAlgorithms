//Problem:https://www.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-doubly-linked-list
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class Solution {
    Node constructDLL(int arr[]) {
        // Code here
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            temp.prev = mover;
            mover.next = temp;
            
            mover = temp;
        }
        return head;
    }
}
public class Problem6 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3,4,5};
       System.out.println( "Answer:"+s.constructDLL(arr).data);
    }
}
