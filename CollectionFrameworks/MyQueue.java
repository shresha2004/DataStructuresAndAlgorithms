import  java.util.Queue;
import java.util.LinkedList;

public class MyQueue {
    public static void main(String[] args) {
        //Creating object
            Queue<Integer> newQueue= new LinkedList<>();

        //Adding elements to the queue
            newQueue.add(100);
            newQueue.add(200);
            newQueue.add(300);
            newQueue.add(400);
            newQueue.add(500);
            System.out.println(newQueue);

        //Top element of the queue
            int x =newQueue.peek();
           System.out.println("Top element of the queue:"+x); 

        //Removing top element 
            int y=newQueue.remove();
            System.out.println("Removed element from the queue:"+y);
        
        //Checking for empty queue
            boolean check =newQueue.isEmpty();
            System.out.println("Queue is empty:"+check);
            
    }
    
}
