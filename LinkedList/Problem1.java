//Problem:https://www.geeksforgeeks.org/problems/introduction-to-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-linked-list
// User function Template for Java


class Node {
    int data;
    Node next;

    
    Node(int d) { data = d; }  //constructor to create a new node
}

class Solution {
    
    static Node constructLL(int arr[]) {
        // code here
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
           mover.next=temp;
            mover=temp;
        }
        return head;
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        Node ans = s.constructLL(arr);
        System.out.println("Answer:"+ans.data);
        
    }
}
