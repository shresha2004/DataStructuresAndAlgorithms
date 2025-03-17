//Problem:
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}

class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        // code here
        int count =0;
        Node mover = head;
        while(mover != null){
            count++;
            mover = mover.next;
        }
        return count;
    }
}

public class Problem4 {
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
        System.out.println("Answer:"+s.getCount(head));
        

    }
}
