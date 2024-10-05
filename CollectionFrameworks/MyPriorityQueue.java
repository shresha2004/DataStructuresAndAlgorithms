import java.util.PriorityQueue;
public class MyPriorityQueue {
    public static void main(String[] args) {

       //Creating instance 
            PriorityQueue<Integer> pq= new PriorityQueue<>();


        //Adding elements
            pq.add(100);
            pq.add(500);
            pq.add(10);
            pq.add(200);
            pq.add(1000);
            pq.add(50);
            System.out.println(pq);

        

        //Printing top element
            int top=pq.peek();
            System.out.println("Top element is:"+top);

        //Removing the top element
            int remove=pq.poll();
            System.out.println("Removed element:"+remove);

        //Traversing each element in priority queue ordeer
        System.out.println("Printing element in priority order:");
        while (!pq.isEmpty()) {
           System.out.print(pq.poll()+" ");
        }
        System.out.println();

    }
    
}
