//Problem:https://leetcode.com/problems/lru-cache/description/
import java.util.*;
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key,int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
   Node head;
   Node tail;
   int capacity;
   int countSize =0;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
       head = new Node(-1,-1);
        tail = new Node(-1,-1);
       head.next = tail;
       tail.prev = head;
       map = new HashMap<>();
       this.capacity = capacity;

    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key)){
        remove(map.get(key));
       }
       else if(map.size()==capacity) remove(tail.prev);
        insert(new Node(key,value));
        }
    private void insert(Node newNode){
        map.put(newNode.key,newNode);
       newNode.next = head.next;
       newNode.prev= head;
       head.next.prev=newNode;
       head.next=newNode; 
    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev =node.prev;
        node.next =null;
        node.prev= null;
    }
}
public class problem26 {
    public static void main(String[] args) {
        //For this we use DLL and hashmap
        LRUCache lru = new LRUCache(2);
        lru.put(1, 100);
        lru.put(2, 200);
        lru.get(2);
    }
}
