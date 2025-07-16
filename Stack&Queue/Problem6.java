//Problem:https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

class MyQueue
{
    QueueNode front=null;
    QueueNode rear=null;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
         QueueNode qn = new QueueNode(a);
        if(front == null){
            front = qn;
            rear = qn;
        }else{
            rear.next = qn;
            rear=qn;
        }
       
        
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        if(front == null) return -1;
        int removed = front.data;
        front = front.next;
        return removed;
	}
}
public class Problem6 {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.push(2);
        mq.push(3);
        mq.push(5);
        mq.push(6);
        System.out.println(mq.pop());
    }
}
