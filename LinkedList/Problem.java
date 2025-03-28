//Problem:https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}




class Solution {
    public Node segregateBruteForce(Node head) {
        // add your code here
        if(head == null || head.next == null) return head;
        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;
        left = segregateBruteForce(left);
        right = segregateBruteForce(right);
        
        return merge(left,right);
    }
    
    
    public Node findMiddle(Node head){
        Node slow = head;
        Node fast = head.next;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
    }
    
    public Node merge(Node list1, Node list2){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        
        while(list1 != null && list2 != null){
            if(list1.data >= list2.data){
                temp.next = list2;
                list2 = list2.next;
            }
            else{
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        if(list1 != null){
            temp.next = list1;
        }
        else{
            temp.next = list2;
        }
        return dummyNode.next;
    }
   
}

public class Problem {
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
    public static void main(String[] args){
        Solution s = new Solution();
        int[] arr = {1,2,2,1,2,0,2,2 };
        Node head = addingArrToLL(arr);
        System.out.println("Brute Force:"+s.segregateBruteForce(head).data);

    }
}