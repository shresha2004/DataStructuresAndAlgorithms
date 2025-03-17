//Problem:https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=search-in-linked-list-1664434326
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}

class Solution {
    static boolean searchKey( Node head, int key) {
        // Code here
      
        Node mover = head;
        while(mover != null){
            if(mover.data == key) return true;
            mover = mover.next;
        }
        return false;
    }
}

public class Problem5 {
    public static Node addingArrToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover=temp;
        }
        return head;  
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3,4};
        Node head = addingArrToLL(arr);
        System.out.println("Answer:"+s.searchKey(head,4));
        

    }
}
