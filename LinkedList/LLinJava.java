class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
   
}

public class LLinJava {
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

    public static void traverseLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void searchInLL(Node head,int key){
        Node temp = head;
        while(temp != null){
            if(temp.data == key){ System.out.println("True");
            return;
        }
            temp=temp.next;
        }
        System.out.println("False");
    }
    public static Node deleteHead(Node head){
        if(head.next == null) return head;
        head= head.next;//Java will automatically delete the refrence when memory is full or after sometimes that address is not pointed by any variable
        System.err.println("After removing head:"+head.data);
        return head;
    }

    public static Node deleteTail(Node head){
        if(head == null || head.next==null) return head;
        Node temp = head;
        while(temp.next.next != null){
            temp=temp.next;
        }
        System.out.println("Removed element:"+temp.next.data);
        temp.next=null;
        return head;
    }

    public static Node deleteKthEle(Node head, int k){
        if(head == null || head.next==null) return head;
        if(k==1){
            head= head.next;
            return head;
        }
        int count=0;
        Node prev=null;
        Node temp = head;
        while(temp != null){
            count++;
            if(count == k){
                prev.next=temp.next;
                //Or prev.next = prev.next.next;
                System.out.println("Deleted element is:"+temp.data);
                break;
            }
            prev= temp;
            temp=temp.next;
        }
        return head;
    }

    public static Node insertHead(Node head, int value){
        Node temp = new Node( value);
        temp.next=head;
       return temp;
    }

    public static Node insertTail(Node head,int value){
        if(head == null) return new Node(value);
        Node temp = head;
        while(temp.next != null){
            temp= temp.next;
        }
        Node newNode = new Node(value);
        temp.next = newNode;
        System.out.println("Element added to tail:"+temp.next.data);
        return head;
    }

    public static Node insertToKthPlace(Node head, int k,int value){
        if(k==1) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            return head;
        }
        int count =0;
        Node temp = head;
        while(temp !=  null){
            count++;
            if(count == k-1){
                Node newNode = new Node(value);
                newNode.next= temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
       int[] arr={12,20,30,40,50};
       Node head =addingArrToLL(arr);
       traverseLL(head);
       searchInLL(head, 50);
       deleteHead(head);
       deleteTail(head);
       deleteKthEle(head, 3);
       head= insertHead(head, 4000);
       insertTail(head, 6000);
       head = insertToKthPlace(head, 4, 400);
       traverseLL(head);

    }
}
