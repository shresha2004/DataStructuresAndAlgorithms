//Problem:https://leetcode.com/problems/implement-stack-using-queues/description/
import java.util.*;
class MyStack {
Stack<Integer> stck = new Stack<>();
Queue<Integer> mq1 = new LinkedList<>();
Queue<Integer> mq2 = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
       
        mq2.add(x);
        while(!mq1.isEmpty()){
            mq2.add(mq1.remove());
        }
        Queue<Integer> temp = mq1;
        mq1=mq2;
        mq2= temp;
    }
    
    public int pop() {
        return mq1.remove();
    }
    
    public int top() {
        return mq1.peek();
    }
    
    public boolean empty() {
        return mq1.isEmpty();
    }
}
public class Problem3 {
    public static void main(String args[]){
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.push(5);
        ms.pop();
        System.out.println(ms.top());
    }
}
