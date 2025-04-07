//Problem:https://leetcode.com/problems/copy-list-with-random-pointer/description/
import java.util.HashMap;
//Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp,newNode);
            temp = temp.next;
        }
        temp =head;
        
        while(temp != null){
            Node current = map.get(temp);
            current.next = map.get(temp.next);
            current.random = map.get(temp.random);
           temp = temp.next;

        }
        return map.get(head);
    }
}
public class Problem30 {
    public static Node addingArrToLL(int arr[]){
        Node head = new  Node(arr[0]);
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

        int[] arr={1,2,3,4};
        Node head = addingArrToLL(arr);
        System.out.println("Answer:"+s.copyRandomList(head).val);
    }
}
