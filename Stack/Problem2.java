class MyQueue {

    int front, rear;
    int arr[] = new int[100005];
    int size = 0;
    MyQueue() {
        front = 0;
        rear = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        if(size==arr.length) return;
        arr[front]=x;
        front = (front+1)%arr.length;
        size++;
        return;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(size==0) return -1;
        size--;
        int removed =arr[rear];
        rear = (rear+1) % arr.length;
        return removed;
        // Your code here
    }
}
public class Problem2 {
    public static void main(String args[]){
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        mq.pop();
        mq.push(5);
        mq.push(6);
    }
}
