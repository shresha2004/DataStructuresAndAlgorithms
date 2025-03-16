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
    public static void main(String[] args) {
        int[] arr={1220,20,30,40,50};
       Node head =addingArrToLL(arr);
       traverseLL(head);
       searchInLL(head, 50);

    }
}
