
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
            head = head.next;
            head.prev = null;
            previous.next = null;
        return head;
    }
   
    public static Node deleteTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node mover = head;
       
        while(mover.next != null){
            mover = mover.next;
        }
        Node previous = mover.prev;
        previous.next = null;
        mover.prev = null;
        return head;
    }
    
    public static Node deleteKthNode(Node head, int k){
        Node temp = head;
        int count = 0;
        while( temp != null){
            count++;
            if(count == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node next = temp.next;
        if(prev == null && next==null) return null;
        else if(prev == null){
            return deleteHead(head);
        }
        else if(next == null)deleteTail(head);
        prev.next = next;
        next.prev =prev;
        temp.prev = null;
        temp.next = null;
        return head;
    }
    
    public static Node deleteGivenNode(Node head,Node  givenNode){
        //givenNode is shd not equal to head (givenNode != head) just bcz u hv to change head so.

        Node previous = givenNode.prev;
        Node next = givenNode.next;
        if(next == null){
            previous.next =null;
            return head;
        }
        previous.next = next;
        next.prev = previous;
        givenNode.prev = givenNode.next = null;
      return head;
    }
   
    public static Node insertBeforeHead(Node head,int data){
        if(head == null){
            Node newNode = new Node(data);
            return newNode;
        }
        Node newNode = new Node(data);
        head.prev= newNode;
        newNode.next = head;
        head = newNode;
        return head;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = doublyLinkedList(arr);
        head = printForward(head);
        Node tail = getTailRefrence(head);
        tail = printBackward(tail);
        head = deleteHead(head);
        head = deleteTail(head);
        head = deleteKthNode(head, 1);
        head =deleteGivenNode(head,head.next.next);
        head = insertBeforeHead(head, 0);
        head = printForward(head);



    }
}
