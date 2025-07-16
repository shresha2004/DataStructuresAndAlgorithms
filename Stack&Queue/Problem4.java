//Problem:https://leetcode.com/problems/implement-queue-using-stacks/description/
import java.util.*;
class MyQueue {
    Stack<Integer> s2 = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!s2.isEmpty()){
            temp.push(s2.pop());
        }
        s2.push(x);
        while(!temp.isEmpty()){
            s2.push(temp.pop());
        }
    }
    
    public int pop() {
        return s2.pop();
    }
    
    public int peek() {
        return s2.peek();
    }
    
    public boolean empty() {
        return s2.isEmpty();
    }
}
public class Problem4 {
  public static void main(String[] args) {
    MyQueue mq = new MyQueue();
    mq.push(1);
    mq.push(2);
    mq.push(3);
    mq.push(4);
    mq.push(5);
    mq.pop();
    System.out.println(mq.peek());
  }   
}
