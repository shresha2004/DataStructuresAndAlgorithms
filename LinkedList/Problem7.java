//Problem:https://leetcode.com/problems/linked-list-cycle/description/
import java.util.HashSet;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
   
}
class Solution {
    public boolean hasCycleBruteForce(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node temp = head;
        while(temp != null){
         if(set.contains(temp)) return true;
           set.add(temp);
           temp= temp.next;
           
        }
        return false;
    }
    public boolean hasCycleOptimal(Node head) {
      Node fast = head;
      Node slow = head;
      while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow) return true;
      }
      return false;
    }
}

public class Problem7 {
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
        int[] arr = {3,2,0,-4};
        Node head = addingArrToLL(arr);
        System.out.println("Brute Force:"+s.hasCycleBruteForce(head));
        System.out.println("Optimal:"+s.hasCycleOptimal(head));
    }
    
}
