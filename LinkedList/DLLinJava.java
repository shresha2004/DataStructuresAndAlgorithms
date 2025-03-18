
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
public class DLLinJava {
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

    public static Node printForward(Node head){
        if(head == null) return head;
        Node temp = head;
        System.out.print("Forward print:");
        while(temp != null){
            System.out.print(" "+temp.data);
            temp= temp.next;
        }
        return head;
    }

    public static Node getTailRefrence(Node head){
        if(head == null) return head;
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }

    public static Node printBackward(Node tail){

        if(tail == null) return tail;
        Node mover = tail;
        System.out.print("\nBackward Print:");
        while(mover != null){
            System.out.print(" "+mover.data);
            mover = mover.prev;
        }
        return tail;
    }
    public static Node deleteHead(Node head){
        if(head == null)  return null;
        Node previous = head;
        Node temp = head.next;
        temp.prev =null;
        previous.next = null;
        head = temp;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = doublyLinkedList(arr);
        head = printForward(head);
        Node tail = getTailRefrence(head);
        tail = printBackward(tail);
        head = deleteHead(head);

    }
}
