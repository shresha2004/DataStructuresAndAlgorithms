
//Problem: https://leetcode.com/problems/lfu-cache/description/
import java.util.*;

class Node {
    int key;
    int value;
    int frequency;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
        this.frequency = 1;
    }
}

class DoubleLinkedList {
    int listSize;
    Node head;
    Node tail;

    public DoubleLinkedList() {
        this.listSize = 0;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node curNode) {
        Node nextNode = head.next;
        curNode.next = nextNode;
        curNode.prev = head;
        head.next = curNode;
        nextNode.prev = curNode;
        listSize++;
    }

    public void removeNode(Node curNode) {
        Node prevNode = curNode.prev;
        Node nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}

class LFUCache {
    HashMap<Integer, Node> cache;
    HashMap<Integer, DoubleLinkedList> freqMap;
    int curSize;
    int minFrequency;
    final int capacity;

    public LFUCache(int capacity) {
        this.freqMap = new HashMap<>();
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

    }

    public int get(int key) {
        Node curNode = cache.get(key);
        if (curNode == null)
            return -1;
        updateNode(curNode);
        return curNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (cache.containsKey(key)) {
            Node curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        } else {
            curSize++;
            if (curSize > capacity) {
                DoubleLinkedList minFreqList = freqMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFrequency = 1;
            Node newNode = new Node(key, value);

            DoubleLinkedList curList = freqMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            freqMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    private void updateNode(Node curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = freqMap.get(curFreq);
        curList.removeNode(curNode);

        if (curFreq == minFrequency && curList.listSize == 0)
            minFrequency++;
        curNode.frequency++;

        DoubleLinkedList newList = freqMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        freqMap.put(curNode.frequency, newList);
    }
}

public class Problem27 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1); 
        cache.put(3, 3);
    }
}
