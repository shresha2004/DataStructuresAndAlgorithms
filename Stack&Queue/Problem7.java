//Problem:https://leetcode.com/problems/min-stack/description/
import java.util.*;
class pair{
    int x,y;
    pair(int x ,int y){
        this.x = x;
        this.y=y;
    }
}
class MinStack {
    Stack<pair> minStack ;
    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
       int min;
       if(minStack.isEmpty()) min = val;
       else min =Math.min(minStack.peek().y,val);
        minStack.push(new pair(val,min));
 
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek().x;
    }
    
    public int getMin() {
        return minStack.peek().y;
    }
}
public class Problem7 {
    public static void main(String[] args) {
        MinStack stck = new MinStack();
        stck.push(3);
        stck.push(8);
        System.out.println(stck.getMin());
        stck.pop();
        stck.push(6);
        stck.push(5);
        System.out.println(stck.getMin());
        
    }
}
